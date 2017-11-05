package com.sportdream;

import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.os.Vibrator;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.example.toastexample.ImagePIckerModuleReactPackage;
import com.example.toastexample.ToastModuleReactPackage;
import com.facebook.react.ReactApplication;
import it.innove.BleManagerPackage;
import com.reactnative.ivpusic.imagepicker.PickerPackage;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
import com.hyphenate.chat.EMClient;
import com.hyphenate.easeui.EaseUI;
import com.sportdream.NativeModule.BaiduMapModuleReactPackage;
import com.sportdream.NativeModule.ClassicBlueToothModuleReactPackage;
import com.sportdream.NativeModule.EaseChatModuleReactPackage;

import com.baidu.mapapi.SDKInitializer;
import com.sportdream.NativeModule.QiniuModuleReactPackage;
import com.sportdream.NativeModule.WiFiDirectModuleReactPackage;
import com.rctunderdark.NetworkManagerPackage;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends MultiDexApplication implements ReactApplication {

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    public boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
            new BleManagerPackage(),
            new PickerPackage(),
          new ToastModuleReactPackage(),
          new ImagePIckerModuleReactPackage(),
          new EaseChatModuleReactPackage(),
          new BaiduMapModuleReactPackage(),
          new QiniuModuleReactPackage(),
              new ClassicBlueToothModuleReactPackage(),
              new WiFiDirectModuleReactPackage(),
              new NetworkManagerPackage()
      );
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);
    EaseUI.getInstance().init(this,null);
    EMClient.getInstance().setDebugMode(true);
    //百度地图sdk
    SDKInitializer.initialize(getApplicationContext());
  }

  /**
   * 分割 Dex 支持
   * @param base
   */
  @Override
  protected void attachBaseContext(Context base) {
    super.attachBaseContext(base);
    MultiDex.install(this);
  }

}
