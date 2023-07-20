package org.cocos2dx.lib;

import android.content.Context;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.nearby.connection.Connections;
import cz.msebera.android.httpclient.impl.client.cache.CacheConfig;

/* loaded from: classes.dex */
public class Cocos2dxEditBox extends EditText {
    public static final int kEndActionNext = 1;
    public static final int kEndActionReturn = 3;
    public static final int kEndActionUnknown = 0;
    private static final int kTextHorizontalAlignmentCenter = 1;
    private static final int kTextHorizontalAlignmentLeft = 0;
    private static final int kTextHorizontalAlignmentRight = 2;
    private static final int kTextVerticalAlignmentBottom = 2;
    private static final int kTextVerticalAlignmentCenter = 1;
    private static final int kTextVerticalAlignmentTop = 0;
    private Boolean changedTextProgrammatically;
    int endAction;
    private final int kEditBoxInputFlagInitialCapsAllCharacters;
    private final int kEditBoxInputFlagInitialCapsSentence;
    private final int kEditBoxInputFlagInitialCapsWord;
    private final int kEditBoxInputFlagLowercaseAllCharacters;
    private final int kEditBoxInputFlagPassword;
    private final int kEditBoxInputFlagSensitive;
    private final int kEditBoxInputModeAny;
    private final int kEditBoxInputModeDecimal;
    private final int kEditBoxInputModeEmailAddr;
    private final int kEditBoxInputModeNumeric;
    private final int kEditBoxInputModePhoneNumber;
    private final int kEditBoxInputModeSingleLine;
    private final int kEditBoxInputModeUrl;
    private final int kKeyboardReturnTypeDefault;
    private final int kKeyboardReturnTypeDone;
    private final int kKeyboardReturnTypeGo;
    private final int kKeyboardReturnTypeNext;
    private final int kKeyboardReturnTypeSearch;
    private final int kKeyboardReturnTypeSend;
    private int mInputFlagConstraints;
    private int mInputModeConstraints;
    private int mMaxLength;
    private float mScaleX;

    public Cocos2dxEditBox(Context context) {
        super(context);
        this.kEditBoxInputModeAny = 0;
        this.kEditBoxInputModeEmailAddr = 1;
        this.kEditBoxInputModeNumeric = 2;
        this.kEditBoxInputModePhoneNumber = 3;
        this.kEditBoxInputModeUrl = 4;
        this.kEditBoxInputModeDecimal = 5;
        this.kEditBoxInputModeSingleLine = 6;
        this.kEditBoxInputFlagPassword = 0;
        this.kEditBoxInputFlagSensitive = 1;
        this.kEditBoxInputFlagInitialCapsWord = 2;
        this.kEditBoxInputFlagInitialCapsSentence = 3;
        this.kEditBoxInputFlagInitialCapsAllCharacters = 4;
        this.kEditBoxInputFlagLowercaseAllCharacters = 5;
        this.kKeyboardReturnTypeDefault = 0;
        this.kKeyboardReturnTypeDone = 1;
        this.kKeyboardReturnTypeSend = 2;
        this.kKeyboardReturnTypeSearch = 3;
        this.kKeyboardReturnTypeGo = 4;
        this.kKeyboardReturnTypeNext = 5;
        this.changedTextProgrammatically = false;
        this.endAction = 0;
    }

    public Boolean getChangedTextProgrammatically() {
        return this.changedTextProgrammatically;
    }

    public float getOpenGLViewScaleX() {
        return this.mScaleX;
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        ((Cocos2dxActivity) getContext()).getGLSurfaceView().requestFocus();
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        return super.onKeyPreIme(i, keyEvent);
    }

    public void setChangedTextProgrammatically(Boolean bool) {
        this.changedTextProgrammatically = bool;
    }

    public void setEditBoxViewRect(int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = i;
        layoutParams.topMargin = i2;
        layoutParams.width = i3;
        layoutParams.height = i4;
        layoutParams.gravity = 51;
        setLayoutParams(layoutParams);
    }

    public void setInputFlag(int i) {
        int i2;
        switch (i) {
            case 0:
                this.mInputFlagConstraints = 129;
                setTypeface(Typeface.DEFAULT);
                setTransformationMethod(new PasswordTransformationMethod());
                break;
            case 1:
                i2 = 524288;
                this.mInputFlagConstraints = i2;
                break;
            case 2:
                i2 = CacheConfig.DEFAULT_MAX_OBJECT_SIZE_BYTES;
                this.mInputFlagConstraints = i2;
                break;
            case 3:
                i2 = 16384;
                this.mInputFlagConstraints = i2;
                break;
            case 4:
                i2 = Connections.MAX_RELIABLE_MESSAGE_LEN;
                this.mInputFlagConstraints = i2;
                break;
            case 5:
                i2 = 1;
                this.mInputFlagConstraints = i2;
                break;
        }
        setInputType(this.mInputFlagConstraints | this.mInputModeConstraints);
    }

    public void setInputMode(int i) {
        int i2;
        setTextHorizontalAlignment(0);
        setTextVerticalAlignment(1);
        switch (i) {
            case 0:
                setTextVerticalAlignment(0);
                i2 = 131073;
                this.mInputModeConstraints = i2;
                break;
            case 1:
                i2 = 33;
                this.mInputModeConstraints = i2;
                break;
            case 2:
                i2 = 4098;
                this.mInputModeConstraints = i2;
                break;
            case 3:
                i2 = 3;
                this.mInputModeConstraints = i2;
                break;
            case 4:
                i2 = 17;
                this.mInputModeConstraints = i2;
                break;
            case 5:
                i2 = 12290;
                this.mInputModeConstraints = i2;
                break;
            case 6:
                this.mInputModeConstraints = 1;
                break;
        }
        setInputType(this.mInputModeConstraints | this.mInputFlagConstraints);
    }

    public void setMaxLength(int i) {
        this.mMaxLength = i;
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.mMaxLength)});
    }

    public void setMultilineEnabled(boolean z) {
        this.mInputModeConstraints |= MetadataChangeSet.INDEXABLE_TEXT_SIZE_LIMIT_BYTES;
    }

    public void setOpenGLViewScaleX(float f) {
        this.mScaleX = f;
    }

    public void setReturnType(int i) {
        int i2;
        switch (i) {
            case 0:
            default:
                setImeOptions(268435457);
                return;
            case 1:
                i2 = 268435462;
                break;
            case 2:
                i2 = 268435460;
                break;
            case 3:
                i2 = 268435459;
                break;
            case 4:
                i2 = 268435458;
                break;
            case 5:
                i2 = 268435461;
                break;
        }
        setImeOptions(i2);
    }

    public void setTextHorizontalAlignment(int i) {
        int i2;
        int gravity = getGravity();
        switch (i) {
            case 0:
            default:
                i2 = (gravity & (-6)) | 3;
                break;
            case 1:
                i2 = (gravity & (-6) & (-4)) | 1;
                break;
            case 2:
                i2 = (gravity & (-4)) | 5;
                break;
        }
        setGravity(i2);
    }

    public void setTextVerticalAlignment(int i) {
        int i2;
        int gravity = getGravity();
        int padding = Cocos2dxEditBoxHelper.getPadding(this.mScaleX);
        switch (i) {
            case 0:
                setPadding(padding, (padding * 3) / 4, 0, 0);
                i2 = (gravity & (-81)) | 48;
                break;
            case 1:
            default:
                setPadding(padding, 0, 0, padding / 2);
                i2 = (gravity & (-49) & (-81)) | 16;
                break;
            case 2:
                i2 = (gravity & (-49)) | 80;
                break;
        }
        setGravity(i2);
    }
}
