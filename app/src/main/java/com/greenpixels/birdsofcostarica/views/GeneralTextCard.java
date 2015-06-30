package com.greenpixels.birdsofcostarica.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.greenpixels.birdsofcostarica.R;

/**
 * Created by chris on 6/29/15.
 */
public class GeneralTextCard extends FrameLayout {

    private String _cardTitle;
    private String _cardBody;

    private final TextView _titleTextView;
    private final TextView _bodyTextView;

    public String getCardTitle() {
        return _cardTitle;
    }

    public void setCardTitle(String cardTitle) {
        _cardTitle = cardTitle;

        if(!TextUtils.isEmpty(_cardTitle))
        {
            _titleTextView.setText(_cardTitle);
        }
    }

    public String getCardBody() {
        return _cardBody;
    }

    public void setCardBody(String cardBody) {
        _cardBody = cardBody;

        if(!TextUtils.isEmpty(_cardBody))
        {
            _bodyTextView.setText(_cardBody);
        }
    }

    public GeneralTextCard(Context context) {
        this(context, null);
    }

    public GeneralTextCard(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GeneralTextCard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater.from(context).inflate(R.layout.card_text_general, this, true);

        _titleTextView = (TextView)findViewById(R.id.card_title_textview);
        _bodyTextView = (TextView)findViewById(R.id.card_body_textview);

        if(!TextUtils.isEmpty(_cardTitle))
        {
            _titleTextView.setText(_cardTitle);
        }

        if(!TextUtils.isEmpty(_cardBody))
        {
            _bodyTextView.setText(_cardBody);
        }

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.GeneralTextCard);

        a.recycle();

    }


}
