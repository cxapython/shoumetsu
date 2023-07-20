package org.apache.james.mime4j.field.address;

import cz.msebera.android.httpclient.message.TokenParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.james.mime4j.codec.EncoderUtil;

/* loaded from: classes.dex */
public class Group extends Address {
    private static final long serialVersionUID = 1;
    private final MailboxList mailboxList;
    private final String name;

    public Group(String str, Collection<Mailbox> collection) {
        this(str, new MailboxList(new ArrayList(collection), true));
    }

    public Group(String str, MailboxList mailboxList) {
        if (str != null) {
            if (mailboxList == null) {
                throw new IllegalArgumentException();
            }
            this.name = str;
            this.mailboxList = mailboxList;
            return;
        }
        throw new IllegalArgumentException();
    }

    public Group(String str, Mailbox... mailboxArr) {
        this(str, new MailboxList(Arrays.asList(mailboxArr), true));
    }

    public static Group parse(String str) {
        Address parse = Address.parse(str);
        if (parse instanceof Group) {
            return (Group) parse;
        }
        throw new IllegalArgumentException("Not a group address");
    }

    @Override // org.apache.james.mime4j.field.address.Address
    protected void doAddMailboxesTo(List<Mailbox> list) {
        Iterator<Mailbox> it = this.mailboxList.iterator();
        while (it.hasNext()) {
            list.add(it.next());
        }
    }

    @Override // org.apache.james.mime4j.field.address.Address
    public String getDisplayString(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append(':');
        Iterator<Mailbox> it = this.mailboxList.iterator();
        boolean z2 = true;
        while (it.hasNext()) {
            Mailbox next = it.next();
            if (z2) {
                z2 = false;
            } else {
                sb.append(',');
            }
            sb.append(TokenParser.SP);
            sb.append(next.getDisplayString(z));
        }
        sb.append(";");
        return sb.toString();
    }

    @Override // org.apache.james.mime4j.field.address.Address
    public String getEncodedString() {
        StringBuilder sb = new StringBuilder();
        sb.append(EncoderUtil.encodeAddressDisplayName(this.name));
        sb.append(':');
        Iterator<Mailbox> it = this.mailboxList.iterator();
        boolean z = true;
        while (it.hasNext()) {
            Mailbox next = it.next();
            if (z) {
                z = false;
            } else {
                sb.append(',');
            }
            sb.append(TokenParser.SP);
            sb.append(next.getEncodedString());
        }
        sb.append(';');
        return sb.toString();
    }

    public MailboxList getMailboxes() {
        return this.mailboxList;
    }

    public String getName() {
        return this.name;
    }
}
