package com.share.bag;

/**
 * Created by Administrator on 2017/12/23.
 * 网址
 */

public class SBUrls {

    //网址拼接头
    public static final String HEAD ="https://baobaoapi.ldlchat.com";
    // 验证码
    public static final String SMSURL = "https://baobaoapi.ldlchat.com/Home/public/getSmsCode.html";
    // 注册
    public static final String REGISTEREDURL = "https://baobaoapi.ldlchat.com/Home/user/register.html";
    // 忘记密码
    public static final String FORGET = "https://baobaoapi.ldlchat.com/Home/user/getnewpwd.html";
    //    登录
    public static final String LOGINURL ="https://baobaoapi.ldlchat.com/Home/user/login.html";
    //    钱包
    public static final String WALLET ="https://baobaoapi.ldlchat.com/Home/wallet/balance.html";
    //修改昵称
    public static final String NICKNAME ="https://baobaoapi.ldlchat.com/Home/my/setnickname.html";
    //卡劵
    public static final String RED ="https://baobaoapi.ldlchat.com/Home/wallet/coupon.html";

    // 要晒的包
    public static final String SHOW = "https://baobaoapi.ldlchat.com/Home/Cabinet/getBagList.html";
    // 猜你喜欢
    public static final String LIKE = "https://baobaoapi.ldlchat.com/Home/Backcontent/ifyoulike.html";
    // 我的包柜                 Cabinet
    public static final String CABINET = "https://baobaoapi.ldlchat.com/Home/Cabinet/cabinetlist.html";
    // 展示收藏
    public static final String COLLECTION = "https://baobaoapi.ldlchat.com/Home/Backcontent/collectionlist.html";
    //                        Collection收藏
//    public static final String COLLECTION="http://baobaoapi.ldlchat.com/Home/Backcontent/collection.html";
    // 以旧换新界面                Cabinet
    public static final String CHANGE = "https://baobaoapi.ldlchat.com/Home/backlist/oldnewlist.html";
    // 正在共享
    public static final String SHARED = "https://baobaoapi.ldlchat.com/Home/Backlist/share.html";


//String url="http://baobaoapi.ldlchat.com/Home/Backlist/share.html";
//    ------------------------------ url -----------------------------------------

    //支付
    public static final String ZHFPAY ="https://baobaoapi.ldlchat.com/Home/Pay/alipaystodo.html";
    //APP_ID
    public static final String APPID = "2018010201523821";
    //PID
    public static final String PID = "2088901865907742";

    public static final String RSA2_PRIVATE = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlkR+whMRcYIybSBl5b1O4Gyv2Y00th/fxn+4tpCRkU1OmGo6l3UESg319yJCXWfIFIHRVCe+11JKiV7OyTYBVX4wC83ekqDVrVwGNBziU0ZrE2gerDRihX66xGGCs0w1TIhQsoawCH1hd61VOz6ABWp3l7yN8WM2KrXkl0OyGC2PVOO01eF9Y8cojPAm3nvOts/056C6X+o5Le9UTZ5m/AGAWOf9u3BBigG8lDrrG1P83+QON6irZcjgI55TJl9QtiNsb9W22xfbJzWVTS1xR4R1EfrkUyE4Cbw2peJSkUqIedZn2vndIN1aQ1G0uXp237rJEQiwRX6vKtm7/RpaeQIDAQAB";
//    public static final String RSA_PRIVATE = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCtcC1NxkGy7Xba8RkseR4eZFJK4Crj8UtgeNKNsIpEJ3tsgVt1wrRqfXoL/y2MtoCFx/8PS4VufsPIb8FFq/rYJN2sq4X+E5FAUOQq+sjc6LccnIKGWQ/v3SB6abvqgp6L0+o4g+LtigsiTNDMIn5vq2TxlWPbVlveXL9UqpmokcFpmh2f5yZvnOTOtwy1UUWwExz2FQ0K5daz+OOoPlOy/L8ebYEUVpYIZmzvNbUE36mFrV4gh//Bgl7dTVLwLTx6zmMIJZaKUtlVjkDMuOHceuXLnmWeUkAZWph5rmMZJ6v2htPDp22uZ2A/V7Pez3uZfkiW0gZGHJj2Y7awmAhxAgMBAAECggEAFrQfihXQ1d5V97Ul6Xd1ZN8XEqwjkTEt/9PxJBEfGGreskaAtXqmaWZBir59tPTTADA9CECHl/5KHLvcXgV0UcUJq6fMY4UmN3gfViz8DEb+aWVnhLS17F1S+hNLQRiWLpGwEHPbSeMPMA9EKeS+DlouXZ2Ds9urLQGRHkEy2ij6q5uCUVwe5Q2xeGhQWSTmAaOeAZS9tMZUx3ju9ME6xdAGjAdO+PAdAjWj1oZfMA4TZfRcSywudbKF4L610NSughKFtQsyjW1EJrBSnScBWQtvTCrCjYrBTrmxNBAIStRZERkNXHnQez+X72tggJWKlvh6wim63P1Wg0NR9eN13QKBgQDxt1HfseAgsaYtrrYpoUwy8NU/fTilfmkHkHiCQHYRDXzQI4BNURNbx2smS33w7jBr2n9O91wcd6N4J6xkeiuZ/loiLU+Y0pTxl0njhxyDfJ1/cyTmjhczIlFYc4R8CtTGBxh5iz/zSMNF64k+QPUVpjzKrOkTZWfNPVTog52B2wKBgQC3r/MFLWzM1NVtgYcs+p5MeNRriTDu+oH0eYonw2LvzvvZflj8QJ6Cue9O/Wlarg56Rf+mb25iDcXZGCTPFSjk+kovYaCea0Q6pBU8yp7UmawIoQtk2scJOHnW9rMJvAj0/cfcEdDBiNINKts0HkjVACUP5zWyfaFidUukobsuowKBgBW+8Fa3ofpPASxK84h7Qmey0vyLP3VkEf7kOHM/aV/PXtM63mgWSy+OmU0wrXvncePCHIH2LwtAmCxPJWtEsneAMouwl+Cf0VaKzdLybNZHd8PnkAJN9jhbdgYHHnwqXUoTiVgl9vLkMO0xa392SJZSBlYViEJ+dQA57FGexaTRAoGBAILwRL8TE3Sr3vwxkido+4CtvVZutFgWcJ7SKL6RlCw4EuWGIG6orZWob0OSdxBx9NYKoeOFmV0CTl+jy1Fm1wDqvgkqgbGL61YV8yGjmjcY2D5KdnHNVoZnIMswjo3I4WWqplZkyLe9DWbffuSXFfnoIYNFoMx8q5cg3+wacfEbAoGAYWw4SL/jnl4A5AUHPOgY3fHUFkcBkEwz8/gPkOT2kf9LZxiuxkJPlu2BWOaDWldzRa2xQaAcb1mtN3rtzrGLDpFC7lkinlpuZlIn4YTg9caO898P1OEM4BEg62U+jse6v5zyYWv4FCl5dN3MelWDAT1EsKhBXnRIA3GZxzdRhZ8=";
    public static final String RSA_PRIVATE = "";

    //微信

//
//    //    注册                                    http://baobaoapi.ldlchat.com/Home/user/register.html
//    public static final String REGISTEREDURL = "http://baobaoapi.ldlchat.com/Home/Public/registered.html";
//    验证码
//    public static final String SMSURL = "http://baobaoapi.ldlchat.com/Home/Public/getSmsk.html";
//                                         http://baobaoapi.ldlchat.com//Home/common/getSmsCode.html
//      首页
    public static final String HOMEURL ="https://baobaoapi.ldlchat.com/Home/Index/index.html";
//    详情
    public static final String DETAILSURL ="https://baobaoapi.ldlchat.com/Home/Backcontent/content.html";
//    展示评论
    public static final String COMMENT ="https://baobaoapi.ldlchat.com/index.php?s=/Home/comment/index.html";


    //      选包（热门）界面
    public static final String POPULAR ="https://baobaoapi.ldlchat.com/Home/Backlist/bagtolist.html";
    public static final String LOGURL="https://baobaoapi.ldlchat.com";
    public static final String CHECK_RECEIVING = "https://baobaoapi.ldlchat.com/Home/Personalcenter/getUserContent.html";
/*
* check
Receiving
* */

    //    ------------------------------ 字符 -----------------------------------------''
    public static final String TOKEN = "TOKEN";
    //上传头像
//
    public static final String UPDATA_IMG = "https://baobaoapi.ldlchat.com/Home/My/uploadheaderimg.html";
//    public static final String UPDATA_IMG = "http://baobaoapi.ldlchat.com/Home/Public/upheaderimg.html";
    //上传头像
//    public static final String UPDATA_IMG = "http://baobaoapi.ldlchat.com/Home/Public/upheaderimg.html";

    //popo
    public static final String JIAZHEN="https://baobaoapi.ldlchat.com/Home/Backlist/bagtolist.html";
    //上传文字和包包图片
    public static final String RELEASE_TEXT_BAG = "https://baobaoapi.ldlchat.com/Home/Userupload/publishbag.html";
}
