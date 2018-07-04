package com.weex.app.extend;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

import com.weex.app.WXPageActivity;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.WXModule;

import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.wechat.moments.WechatMoments;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.onekeyshare.ShareContentCustomizeCallback;

public class ShareSDKCustomModule extends WXModule {


    public static String shareText,shareUrl,shareTitle,shareImage,siteName;

    @JSMethod()
    public void show() {


        OnekeyShare oks = new OnekeyShare();
        oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
        oks.setTitleUrl("http://www.baidu.com");
        oks.setText("22222");
        oks.setTitle("1111111");
        oks.setPlatform(QQ.NAME);
        oks.show(mWXSDKInstance.getContext());


    }

    @JSMethod()
    public void wechat() {

        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();


         shareText = "shareText shareText shareText";
         shareTitle = "shareTitle";
         shareUrl = "www.baidu.com";
         shareImage = "http://dev.e-shigong.com/ic_launcher.png";
         siteName = "youlu";

        /**
         * 下面的这些参数必须要写，某些不写会导致某些平台分享失败
         */
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle(shareTitle);
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl(shareUrl);
        // text是分享文本，所有平台都需要这个字段
        oks.setText(shareText);
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数,
        // 使用 imagePath 必须保证SDcard下面存在此张图片
        //imagePath,imageUrl 必须保留一个，否则微信不能分享，或者分享过去的图片都是应用的 logo
        oks.setImageUrl(shareImage);
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(shareUrl);
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(siteName);
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl(shareUrl);


        /**
         * 真正分享出去的内容实际上是由下面的这些参数决定的，根据平台不同分别配置
         */
        oks.setShareContentCustomizeCallback(new ShareContentCustomizeCallback() {
            @Override
            public void onShare(Platform platform, cn.sharesdk.framework.Platform.ShareParams paramsToShare) {
                if (Wechat.NAME.equals(platform.getName()) ||
                        WechatMoments.NAME.equals(platform.getName())) {
                    paramsToShare.setShareType(Platform.SHARE_WEBPAGE);
                    paramsToShare.setUrl(shareUrl);
                    paramsToShare.setText(shareText);
                    paramsToShare.setImageUrl(shareImage);
                    paramsToShare.setTitle(shareTitle);
                }
                if (SinaWeibo.NAME.equals(platform.getName())) {
                    paramsToShare.setText(shareText);
                    paramsToShare.setUrl(shareUrl);
                    paramsToShare.setImageUrl(shareImage);
                }
                if (QQ.NAME.equals(platform.getName())) {
                    paramsToShare.setTitle(shareTitle);
                    paramsToShare.setTitleUrl(shareUrl);
                    paramsToShare.setText(shareText);
                    paramsToShare.setUrl(shareUrl);
                    paramsToShare.setImageUrl(shareImage);
                }
            }
        });

        oks.show(mWXSDKInstance.getContext());
    }

}
