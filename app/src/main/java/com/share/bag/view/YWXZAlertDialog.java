package com.share.bag.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.share.bag.R;

/**
 * @ClassName: AlertDialog
 * @Description: 自定义样式的对话框（公共）
 */
public class YWXZAlertDialog extends Dialog implements android.view.View.OnClickListener{

    private Context context = null;
    
    // 标题
    private String title = "温馨提示";
    // 内容
    private String content = null;
    // 是否显示标题，默认显示
    private boolean visibleTitle = true;
    
    private String yesBtnName = "是";
    
    private String noBtnName = "否";
    
    private String cancelBtnName = "取消";
    
    private boolean yesBtnGone = false;
    
    private boolean noBtnGone = false;
    
    private boolean cancelBtnGone = false;
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
	public boolean isVisibleTitle() {
        return visibleTitle;
    }
	
    public void setVisibleTitle(boolean visibleTitle) {
        this.visibleTitle = visibleTitle;
    }

    public String getYesBtnName() {
        return yesBtnName;
    }

    public void setYesBtnName(String yesBtnName) {
        this.yesBtnName = yesBtnName;
    }

    public String getNoBtnName() {
        return noBtnName;
    }

    public void setNoBtnName(String noBtnName) {
        this.noBtnName = noBtnName;
    }

    public String getCancelBtnName() {
        return cancelBtnName;
    }

    public void setCancelBtnName(String cancelBtnName) {
        this.cancelBtnName = cancelBtnName;
    }

    public boolean isYesBtnGone() {
        return yesBtnGone;
    }

    public void setYesBtnGone(boolean yesBtnGone) {
        this.yesBtnGone = yesBtnGone;
    }

    public boolean isNoBtnGone() {
        return noBtnGone;
    }

    public void setNoBtnGone(boolean noBtnGone) {
        this.noBtnGone = noBtnGone;
    }

    public boolean isCancelBtnGone() {
        return cancelBtnGone;
    }

    public void setCancelBtnGone(boolean cancelBtnGone) {
        this.cancelBtnGone = cancelBtnGone;
    }
    
    public YWXZAlertDialog(Context context) {
        super(context, R.style.showphonedialog);
        this.context = context;
    }
    
    public YWXZAlertDialog(Context context, String content) {
        super(context, R.style.showphonedialog);
        this.context = context;
        this.content = content;
    }
    
    public YWXZAlertDialog(Context context, String title, String content) {
		super(context, R.style.showphonedialog);
		this.context = context;
		this.title = title;
		this.content = content;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setBackgroundDrawableResource(android.R.color.transparent);
		View view = LayoutInflater.from(context)
                .inflate(R.layout.uilib_alert_dialog, null);
		setContentView(view, new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
		TextView doYes = (TextView) findViewById(R.id.doYes);
		TextView doNo = (TextView) findViewById(R.id.doNo);
		TextView doCancel = (TextView) findViewById(R.id.doCancel);
		//动态设置按钮的背景
		if(!isYesBtnGone() && isNoBtnGone() && isCancelBtnGone()){//显示一个按钮
			doYes.setBackgroundResource(R.drawable.uilib_textview_dialog_one_selector);
		}else if(isYesBtnGone() && !isNoBtnGone() && isCancelBtnGone()){
			doNo.setBackgroundResource(R.drawable.uilib_textview_dialog_one_selector);
		}else if(isYesBtnGone() && isNoBtnGone() && !isCancelBtnGone()){
			doCancel.setBackgroundResource(R.drawable.uilib_textview_dialog_one_selector);
		}else if(!isYesBtnGone() && !isNoBtnGone() && isCancelBtnGone()){//显示两个按钮
			doYes.setBackgroundResource(R.drawable.uilib_textview_dialog_right_selector);
			doNo.setBackgroundResource(R.drawable.uilib_textview_dialog_left_selector);
		}else if(!isYesBtnGone() && isNoBtnGone() && !isCancelBtnGone()){
			doYes.setBackgroundResource(R.drawable.uilib_textview_dialog_right_selector);
			doCancel.setBackgroundResource(R.drawable.uilib_textview_dialog_left_selector);
		}else if(isYesBtnGone() && !isNoBtnGone() && !isCancelBtnGone()){
			doCancel.setBackgroundResource(R.drawable.uilib_textview_dialog_right_selector);
			doNo.setBackgroundResource(R.drawable.uilib_textview_dialog_left_selector);
		}else if(!isYesBtnGone() && !isNoBtnGone() && !isCancelBtnGone()){//显示三个按钮
			doYes.setBackgroundResource(R.drawable.uilib_textview_dialog_right_selector);
			doCancel.setBackgroundResource(R.drawable.uilib_textview_dialog_left_selector);
			doNo.setBackgroundResource(R.drawable.uilib_textview_dialog_among_selector);
		}
		
		Window window = this.getWindow();
        WindowManager.LayoutParams wl = window.getAttributes();
        wl.x = 0;
        wl.y =  getScreenHeight((Activity) context)/1000;
        // 保证按钮水平满屏
        wl.width = getScreenWidth((Activity) context) - 200;
        wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        // 设置显示位置
        this.onWindowAttributesChanged(wl);
        
		// 标题
        TextView titleTv = (TextView) findViewById(R.id.title);
        if (visibleTitle) {
            titleTv.setText(title);
        } else {
            titleTv.setVisibility(View.GONE);
        }
        // 内容
        TextView contentDcTv = (TextView) findViewById(R.id.content);
        contentDcTv.setText(content);
        
        doYes.setOnClickListener(this);
        doYes.setText(yesBtnName);
        if (yesBtnGone) {
            findViewById(R.id.doNoLine).setVisibility(View.GONE);
            doYes.setVisibility(View.GONE);
        }
        
        doNo.setOnClickListener(this);
        doNo.setText(noBtnName);
        if (noBtnGone) {
            findViewById(R.id.doNoLine).setVisibility(View.GONE);
            doNo.setVisibility(View.GONE);
        }
        
        doCancel.setOnClickListener(this);
        doCancel.setText(cancelBtnName);
        if (cancelBtnGone) {
            findViewById(R.id.doCancleLine).setVisibility(View.GONE);
            doCancel.setVisibility(View.GONE);
        }
	}
	
	@Override
	public void onClick(View v) {
		// As of ADT 14, resource fields cannot be
		// used as switch cases. Invoke this fix to get more information.
		// 如果项目勾选了Is Library，R文件生成的字段会变成public static int,而不是public static final int,所以才会出现上面的错误。
		if (v.getId() == R.id.doYes) {
			if(myDialogOnClickListener!=null) {
				myDialogOnClickListener.onYes();
			}
		} else if (v.getId() == R.id.doNo) {
			if(myDialogOnClickListener!=null) {
                myDialogOnClickListener.onNo();
            }
		} else if (v.getId() == R.id.doCancel) {
			if(myDialogOnClickListener!=null) {
                myDialogOnClickListener.onCancel();
            }
		}
	}
	
	public AlertDialogOnClickListener myDialogOnClickListener = null;
    
    public interface AlertDialogOnClickListener{
        void onYes();
        void onNo();
        void onCancel();
    }
    
    public void setOnAlertDialogOnClick(AlertDialogOnClickListener listener){
        myDialogOnClickListener =  listener;
    }
    /**
     * 获得屏幕高度
     * @param context 上下文对象
     * @return 屏幕高度px
     */
    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    /**
     * 获得屏幕宽度
     * @param context 上下文对象
     * @return 屏幕宽度px
     */
    public static int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }

}
