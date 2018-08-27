package com.snapps.etlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;

import java.util.ArrayList;

public class MaskedEditText extends android.support.v7.widget.AppCompatEditText implements TextWatcher {

    private Context context;

    private ArrayList<Integer> maskPositionArray = new ArrayList<>();

    private ArrayList<Character> maskCharacters = new ArrayList<>();

    private boolean textChange;

    private String mask;

    private int maxLength;

    boolean backspace = false;

    public MaskedEditText(Context context) {
        super(context);
        this.context = context;
    }

    public MaskedEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        getMask(attrs);
        setMaxLength();
    }

    private void getMask(AttributeSet attrs){
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.MaskedEditText);
        mask = attributes.getString(R.styleable.MaskedEditText_mask);
        maxLength = mask.length();

        for(int i = 0 ; i < maxLength; i++){
            char c = mask.charAt(i);
            if (c != '#'){
                maskPositionArray.add(i); // compose array for posistioning mask
                maskCharacters.add(c);
            }
        }
    }

    private void setMaxLength(){
        InputFilter[] filterArray = new InputFilter[1];
        filterArray[0] = new InputFilter.LengthFilter(maxLength);
        MaskedEditText.this.setFilters(filterArray);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        if (count > after) {
            backspace = true;
        }
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if ((!(before == count)))
            textChange = true;
        else
            MaskedEditText.this.setSelection(MaskedEditText.this.getText().length() );

        if (textChange) {
            String val = MaskedEditText.this.getText().toString();
            String finalVal ="";

            int i = 0;

            while (i < (val.length())){
                char c = val.charAt(i);

                i++;
                while (maskPositionArray.contains(finalVal.length())){//check if we have some masking character to be placed at the current position
                    finalVal += maskCharacters.get((maskPositionArray.indexOf(finalVal.length())));
                    textChange = true;
                }
                if (!(maskCharacters.contains(c))) {//check if the current character in loop is not some masking character (As that'll already be handled in above block
                    finalVal += c;
                    textChange = true;
                }

            }

            i = finalVal.length();
            while (maskPositionArray.contains(i)){
                finalVal += maskCharacters.get(maskPositionArray.indexOf(i));
                i++;
            }
            textChange = false;
            MaskedEditText.this.setText(finalVal);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
    }
}