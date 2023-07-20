package org.apache.james.mime4j.field.address;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.StringReader;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.james.mime4j.field.address.parser.AddressListParser;

/* loaded from: classes.dex */
public class AddressList extends AbstractList<Address> implements Serializable {
    private static final long serialVersionUID = 1;
    private final List<? extends Address> addresses;

    public AddressList(List<? extends Address> list, boolean z) {
        if (list == null) {
            list = Collections.emptyList();
        } else if (!z) {
            list = new ArrayList(list);
        }
        this.addresses = list;
    }

    public static void main(String[] strArr) {
        String readLine;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("> ");
                readLine = bufferedReader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
                Thread.sleep(300L);
            }
            if (readLine.length() != 0 && !readLine.toLowerCase().equals("exit") && !readLine.toLowerCase().equals("quit")) {
                parse(readLine).print();
            }
            System.out.println("Goodbye.");
            return;
        }
    }

    public static AddressList parse(String str) {
        return Builder.getInstance().buildAddressList(new AddressListParser(new StringReader(str)).parseAddressList());
    }

    public MailboxList flatten() {
        boolean z;
        Iterator<? extends Address> it = this.addresses.iterator();
        while (true) {
            if (it.hasNext()) {
                if (!(it.next() instanceof Mailbox)) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            return new MailboxList(this.addresses, true);
        }
        ArrayList arrayList = new ArrayList();
        for (Address address : this.addresses) {
            address.addMailboxesTo(arrayList);
        }
        return new MailboxList(arrayList, false);
    }

    @Override // java.util.AbstractList, java.util.List
    public Address get(int i) {
        return this.addresses.get(i);
    }

    public void print() {
        for (Address address : this.addresses) {
            System.out.println(address.toString());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.addresses.size();
    }
}
