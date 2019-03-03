package com.example.matias.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    String url = "https://frisbeegolfradat.fi/radat/haku";//fields in alpabetical order
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textview);
        getwebsite();
    }

    private void getwebsite(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                final StringBuilder builder = new StringBuilder();
                String field_name_website_url = "";
                try {
                    Document doc = Jsoup.connect(url).get();
                    Elements links = doc.select("table#radatlistaus>tbody>tr");
                    for (Element link : links){
                        String img_url = link.select("a[href]:contains(Kartta)").attr("href");
                        if(img_url == ""){img_url="Karttaa ei ole";}
                        String field_name = link.select("td.rataCol>a").text();
                        field_name_website_url = link.select("td.rataCol>a").attr("href")
                                .replace(" ","_");
                        String place = link.select("td.paikkaCol").text();
                        String lane = link.select("td").get(4).text();
                        builder.append(field_name)
                                .append("\n")
                                .append(place)
                                .append("\n")
                                .append("Väyliä : "+lane)
                                .append("\n")
                                .append(img_url)
                                .append("\n")
                                .append(url+field_name_website_url)
                                .append("\n")
                                .append("\n");
                    }
                } catch (IOException e){
                    builder.append("Error : "+field_name_website_url+"\n"+e.getMessage());
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(builder.toString());
                    }
                });
            }
        }).start();
    }
}
