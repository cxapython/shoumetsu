package net.gree.gamelib.moderation.a;

import java.text.Normalizer;

/* loaded from: classes.dex */
public class f {
    private static final String[][] a = {new String[]{"ｶﾞ", "ガ"}, new String[]{"ｷﾞ", "ギ"}, new String[]{"ｸﾞ", "グ"}, new String[]{"ｹﾞ", "ゲ"}, new String[]{"ｺﾞ", "ゴ"}, new String[]{"ｻﾞ", "ザ"}, new String[]{"ｼﾞ", "ジ"}, new String[]{"ｽﾞ", "ズ"}, new String[]{"ｾﾞ", "ゼ"}, new String[]{"ｿﾞ", "ゾ"}, new String[]{"ﾀﾞ", "ダ"}, new String[]{"ﾁﾞ", "ヂ"}, new String[]{"ﾂﾞ", "ヅ"}, new String[]{"ﾃﾞ", "デ"}, new String[]{"ﾄﾞ", "ド"}, new String[]{"ﾊﾞ", "バ"}, new String[]{"ﾋﾞ", "ビ"}, new String[]{"ﾌﾞ", "ブ"}, new String[]{"ﾍﾞ", "ベ"}, new String[]{"ﾎﾞ", "ボ"}, new String[]{"ﾊﾟ", "パ"}, new String[]{"ﾋﾟ", "ピ"}, new String[]{"ﾌﾟ", "プ"}, new String[]{"ﾍﾟ", "ペ"}, new String[]{"ﾎﾟ", "ポ"}, new String[]{"ｳﾞ", "ヴ"}, new String[]{"ｱ", "ア"}, new String[]{"ｲ", "イ"}, new String[]{"ｳ", "ウ"}, new String[]{"ｴ", "エ"}, new String[]{"ｵ", "オ"}, new String[]{"ｶ", "カ"}, new String[]{"ｷ", "キ"}, new String[]{"ｸ", "ク"}, new String[]{"ｹ", "ケ"}, new String[]{"ｺ", "コ"}, new String[]{"ｻ", "サ"}, new String[]{"ｼ", "シ"}, new String[]{"ｽ", "ス"}, new String[]{"ｾ", "セ"}, new String[]{"ｿ", "ソ"}, new String[]{"ﾀ", "タ"}, new String[]{"ﾁ", "チ"}, new String[]{"ﾂ", "ツ"}, new String[]{"ﾃ", "テ"}, new String[]{"ﾄ", "ト"}, new String[]{"ﾅ", "ナ"}, new String[]{"ﾆ", "ニ"}, new String[]{"ﾇ", "ヌ"}, new String[]{"ﾈ", "ネ"}, new String[]{"ﾉ", "ノ"}, new String[]{"ﾊ", "ハ"}, new String[]{"ﾋ", "ヒ"}, new String[]{"ﾌ", "フ"}, new String[]{"ﾍ", "ヘ"}, new String[]{"ﾎ", "ホ"}, new String[]{"ﾏ", "マ"}, new String[]{"ﾐ", "ミ"}, new String[]{"ﾑ", "ム"}, new String[]{"ﾒ", "メ"}, new String[]{"ﾓ", "モ"}, new String[]{"ﾔ", "ヤ"}, new String[]{"ﾕ", "ユ"}, new String[]{"ﾖ", "ヨ"}, new String[]{"ﾗ", "ラ"}, new String[]{"ﾘ", "リ"}, new String[]{"ﾙ", "ル"}, new String[]{"ﾚ", "レ"}, new String[]{"ﾛ", "ロ"}, new String[]{"ﾜ", "ワ"}, new String[]{"ｦ", "ヲ"}, new String[]{"ﾝ", "ン"}, new String[]{"ｧ", "ァ"}, new String[]{"ｨ", "ィ"}, new String[]{"ｩ", "ゥ"}, new String[]{"ｪ", "ェ"}, new String[]{"ｫ", "ォ"}, new String[]{"ｬ", "ャ"}, new String[]{"ｭ", "ュ"}, new String[]{"ｮ", "ョ"}, new String[]{"ｯ", "ッ"}, new String[]{"｡", "。"}, new String[]{"｢", "「"}, new String[]{"｣", "」"}, new String[]{"､", "、"}, new String[]{"･", "・"}, new String[]{"ｰ", "ー"}, new String[]{"", ""}};
    private static final String b = ".*[[！-ﾝ][￥]].*";

    public String a(String str) {
        if (!str.matches(b)) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (i < str.length()) {
            Character valueOf = Character.valueOf(str.charAt(i));
            if ((valueOf.compareTo((Character) 65281) < 0 || valueOf.compareTo((Character) 65376) > 0) && valueOf.compareTo((Character) 65509) != 0) {
                if (valueOf.compareTo((Character) 65377) >= 0 && valueOf.compareTo((Character) 65437) <= 0) {
                    String substring = str.substring(i);
                    int i2 = 0;
                    while (true) {
                        String[][] strArr = a;
                        if (i2 >= strArr.length) {
                            break;
                        } else if (substring.startsWith(strArr[i2][0])) {
                            stringBuffer.append(a[i2][1]);
                            i += a[i2][0].length() - 1;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i2 < a.length) {
                    }
                }
                stringBuffer.append(valueOf);
            } else {
                stringBuffer.append(Normalizer.normalize(String.valueOf(valueOf), Normalizer.Form.NFKC));
            }
            i++;
        }
        return stringBuffer.toString();
    }
}
