package com.mihir.answers;

import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.ContentViewEvent;
import com.crashlytics.android.answers.CustomEvent;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySeyIterator;
import com.facebook.react.bridge.ReadableType;


/**
 * Created by mihir on 1/17/16.
 */
public class RnAnswers extends ReactContextBaseJavaModule {
    public RnAnswers(ReactApplicationContext reactContext) {
        super(reactContext);
    }
    @Override
    public String getName() {
        return "FabricAnswers";
    }
    @ReactMethod
    public void logCustomEvent(final String eventName,final ReadableMap args){
        CustomEvent custom = new CustomEvent(eventName);
        ReadableMapKeySeyIterator  iterator = args.keySetIterator();
        while (iterator.hasNextKey()){
            String key = iterator.nextKey();
            ReadableType valType = args.getType(key);
            switch (valType){
                case Number:
                    custom.putCustomAttribute(key,args.getDouble(key));
                    break;
                case String :
                    custom.putCustomAttribute(key,args.getString(key));
                    break;
                case Null:
                    break;
                default:
                    throw new IllegalArgumentException("Please provide valid attributes");
            }
        }
        Answers.getInstance().logCustom(custom);
    }
    @ReactMethod
    public void logViewEvent(final ReadableMap args){
        ContentViewEvent newView = new ContentViewEvent();
        newView.putContentId(args.getString("contentId"));
        newView.putContentName(args.getString("contentName"));
        newView.putContentType(args.getString("contentType"));
        if(args.hasKey("customAttributes")){
            ReadableMap customAttributes = args.getMap("attributes");
            ReadableMapKeySeyIterator  iterator = customAttributes.keySetIterator();
            while(iterator.hasNextKey()){
                String key = iterator.nextKey();
                ReadableType valType = args.getType(key);
                switch (valType){
                    case Number:
                        newView.putCustomAttribute(key,args.getDouble(key));
                        break;
                    case String :
                        newView.putCustomAttribute(key,args.getString(key));
                        break;
                    case Null:
                        break;
                    default:
                        throw new IllegalArgumentException("Please provide valid attributes");
                }
            }
        }
        Answers.getInstance().logContentView(newView);
    }
}