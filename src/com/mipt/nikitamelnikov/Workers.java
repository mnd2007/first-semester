package com.mipt.nikitamelnikov;

abstract class Workers {
    public abstract void work(int number);

    public boolean goHome(String str1, String str2) {
        return str1.equals(str2);
    }
}