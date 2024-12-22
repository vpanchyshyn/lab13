package ua.edu.ucu.apps.task2;

public class Authorization extends Авторизація{
    public boolean authorize (БазаДаних db) {
        return super.авторизуватися(db);
    }
    @Override @Deprecated
    public boolean авторизуватися(БазаДаних db) {
        return super.авторизуватися(db);
    }
}
