package org.unimelb.closablebindingview;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import java.util.HashMap;

/**
 * Created by Paul on 7/6/17.
 */

public class ClosableButtonLinearLayout extends LinearLayout{

    public ClosableButtonLinearLayout(Context context) {
        super(context);
        init();
    }

    public ClosableButtonLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        setOrientation(HORIZONTAL);

    }

    private static class ButtonFactory{
        private final int BUTTON_LAYOUT_HEIGHT = 64;
        private final int ICON_SIZE = 20;
        private final int ICON_TOP_MARGIN = 15;
        private final int TEXT_SIZE = 11;
        private final int TEXT_BOTTOM_MARGIN = 7;
        private final int COLOR_TEXT = Color.parseColor("#424242");

        private static ButtonFactory instance;

        private HashMap<ButtonItem, ClosableRelativeLayout> buttonHashMap;

        private ButtonFactory(){
            buttonHashMap = new HashMap<>();
        }

        private static ButtonFactory getInstance(){
            if (instance==null){
                instance = new ButtonFactory();
            }
            return instance;
        }

        public ClosableRelativeLayout create(ButtonItem item){
            ClosableRelativeLayout closableRelativeLayout = buttonHashMap.get(item);

        }


    }



}
