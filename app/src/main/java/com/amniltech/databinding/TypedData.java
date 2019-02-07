package com.amniltech.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import io.reactivex.internal.operators.observable.ObservableInternalHelper;

public class TypedData extends BaseObservable {
    private String typedText;
//    private Boolean visible;
//    private String counter;
//    private String speed;

    @Bindable
    public String getTrimedTypedText() {
        if (getVisible())
            return typedText.trim();
        else
            return "";
    }

    @Bindable
    public String getTypedText(){
        return typedText;
    }

    public void setTypedText(String typedText) {
        this.typedText = typedText;
        notifyPropertyChanged(BR.typedText);
        notifyPropertyChanged(BR.visible);
        notifyPropertyChanged(BR.counter);
        notifyPropertyChanged(BR.trimedTypedText);
        notifyPropertyChanged(BR.wordCounter);
    }

    @Bindable
    public Boolean getVisible() {

        return typedText != null && !typedText.trim().isEmpty();
    }

    @Bindable
    public String getCounter(){
        if(getVisible())
            return String.valueOf("Characters: "+typedText.trim().length());
        else
            return "0";
    }

    @Bindable
    public String getTypingSpeed(){
        return "";
    }

    @Bindable
    public String getWordCounter(){
        if (getVisible())
            return String.valueOf("Words: "+typedText.split("\\s+").length);
        else
            return "0";
    }

}
