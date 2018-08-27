package com.rosinante.pdfviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.joanzapata.pdfview.PDFView;
import com.joanzapata.pdfview.listener.OnPageChangeListener;

public class MainActivity extends AppCompatActivity implements OnPageChangeListener {

    public static final String SAMPLENOVEL = "mahoukanovelvolthird.pdf";

    PDFView pdfView;
    String pdfName = SAMPLENOVEL;
    Integer pageNumber = 211;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pdfView = findViewById(R.id.pdfview);
        displayPDF(pdfName);
    }

    private void displayPDF(String assetsFileName) {
        pageNumber = 1;
        setTitle(pdfName = assetsFileName);
        pdfView.fromAsset(assetsFileName).defaultPage(pageNumber).onPageChange(this).enableSwipe(true).load();
    }

    @Override
    public void onPageChanged(int page, int pageCount) {
        pageNumber = page;
        setTitle(pdfName = String.valueOf(pageNumber));
    }
}
