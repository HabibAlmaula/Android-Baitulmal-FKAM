package com.baitulmalfkam.baitulmalfkam.Detail;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.widget.ImageView;
import android.widget.TextView;

import com.baitulmalfkam.baitulmalfkam.ImageGetter.URLImageParser;
import com.baitulmalfkam.baitulmalfkam.POJO.ListItem;
import com.baitulmalfkam.baitulmalfkam.R;
import com.squareup.picasso.Picasso;

public class DetailHomeActivity extends AppCompatActivity {
    ImageView main_backdrop;
    TextView textview_content;
    Toolbar main_toolbar;
    CollapsingToolbarLayout main_collapsing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_home);

        ListItem content = getIntent().getParcelableExtra("HOME");

        main_backdrop = findViewById(R.id.main_backdrop);
        textview_content = findViewById(R.id.textview_content);
        main_toolbar = findViewById(R.id.main_toolbar);
        main_collapsing = findViewById(R.id.main_collapsing);
        setSupportActionBar(main_toolbar);

        Picasso.with(this).load(content.getThumbnail()).into(main_backdrop);

        String text_title = content.getTitle();
        String textCont = content.getContent();
        String newString = textCont.replace("<div id=\"vfb-form-1\" class=\"visual-form-builder-container\"><form id=\"konfirmasi-1\" class=\"visual-form-builder vfb-form-1 \" method=\"post\" enctype=\"multipart/form-data\"> <input type=\"hidden\" name=\"form_id\" value=\"1\" /><fieldset class=\"vfb-fieldset vfb-fieldset-1 konfirmasi-setelah-anda-transfer-donasi \" id=\"item-vfb-1\"><div class=\"vfb-legend\"><h3>Konfirmasi setelah anda transfer donasi</h3></div><ul class=\"vfb-section vfb-section-1\"><li class=\"vfb-item vfb-item-text   vfb-left-half\" id=\"item-vfb-5\"><label for=\"vfb-5\" class=\"vfb-desc\">Nama Lengkap </label><input type=\"text\" name=\"vfb-5\" id=\"vfb-5\" value=\"\" class=\"vfb-text  vfb-small   \" /></li><li class=\"vfb-item vfb-item-text   vfb-left-half\" id=\"item-vfb-82\"><label for=\"vfb-82\" class=\"vfb-desc\">Alamat Lengkap </label><input type=\"text\" name=\"vfb-82\" id=\"vfb-82\" value=\"\" class=\"vfb-text  vfb-medium   \" /></li><li class=\"vfb-item vfb-item-phone  \" id=\"item-vfb-20\"><label for=\"vfb-20\" class=\"vfb-desc\">No. HP (Whatsapp) </label><input type=\"tel\" name=\"vfb-20\" id=\"vfb-20\" value=\"\" class=\"vfb-text  vfb-medium   phone \" /></li><li class=\"vfb-item vfb-item-email  \" id=\"item-vfb-18\"><label for=\"vfb-18\" class=\"vfb-desc\">Email </label><input type=\"email\" name=\"vfb-18\" id=\"vfb-18\" value=\"\" class=\"vfb-text  vfb-medium   email \" /></li><li class=\"vfb-item vfb-item-currency  \" id=\"item-vfb-22\"><label for=\"vfb-22\" class=\"vfb-desc\">Jumlah Donasi </label><input type=\"text\" name=\"vfb-22\" id=\"vfb-22\" value=\"\" class=\"vfb-text  vfb-medium   number \" /></li><li class=\"vfb-item vfb-item-checkbox  \" id=\"item-vfb-23\"><label class=\"vfb-desc\">Cara Donasi </label><div><span><label>* Ceklist salah satu cara donasi yang Anda lakukan</label></span><span class=\"vfb-span\"><input type=\"checkbox\" name=\"vfb-23[]\" id=\"vfb-23-0\" value=\"Transfer ATM\" class=\"vfb-checkbox  \" /><label for=\"vfb-23-0\" class=\"vfb-choice\">Transfer ATM</label></span><span class=\"vfb-span\"><input type=\"checkbox\" name=\"vfb-23[]\" id=\"vfb-23-1\" value=\"Internet Banking\" class=\"vfb-checkbox  \" /><label for=\"vfb-23-1\" class=\"vfb-choice\">Internet Banking</label></span><span class=\"vfb-span\"><input type=\"checkbox\" name=\"vfb-23[]\" id=\"vfb-23-2\" value=\"Mobile Banking\" class=\"vfb-checkbox  \" /><label for=\"vfb-23-2\" class=\"vfb-choice\">Mobile Banking</label></span><div style=\"clear:both\"></div></div></li><li class=\"vfb-item vfb-item-date  \" id=\"item-vfb-13\"><label for=\"vfb-13\" class=\"vfb-desc\">Tanggal Donasi </label><input type=\"text\" name=\"vfb-13\" id=\"vfb-13\" value=\"\" class=\"vfb-text vfb-date-picker  vfb-small  \" data-dp-dateFormat=\"mm/dd/yy\" /></li><li class=\"vfb-item vfb-item-text  \" id=\"item-vfb-14\"><label for=\"vfb-14\" class=\"vfb-desc\">Nama Bank Asal </label><input type=\"text\" name=\"vfb-14\" id=\"vfb-14\" value=\"\" class=\"vfb-text  vfb-medium   \" /></li><li class=\"vfb-item vfb-item-select  \" id=\"item-vfb-25\"><label for=\"vfb-25\" class=\"vfb-desc\">Rekening Tujuan dan Jenis Donasi </label><span class=\"vfb-span\"><label>Bank Syariah Mandiri & CIMB NIaga Syariah</label></span><select name=\"vfb-25\" id=\"vfb-25\" class=\"vfb-select  vfb-medium  \"><option value=\"BSM 7002076203 (Zakat)\">BSM 7002076203 (Zakat)</option><option value=\"BSM 7002074284 (Infaq dan Shadaqah)\">BSM 7002074284 (Infaq dan Shadaqah)</option><option value=\"BSM 7002063411 (Yatim)\">BSM 7002063411 (Yatim)</option><option value=\"BSM 7048694262 (Dhuafa)\">BSM 7048694262 (Dhuafa)</option><option value=\"BSM 7002074286 (Tanggap Bencana)\">BSM 7002074286 (Tanggap Bencana)</option><option value=\"BSM 7048694424 (Pemb. Sarana Ibadah)\">BSM 7048694424 (Pemb. Sarana Ibadah)</option><option value=\"BSM 7083865711 (Kesehatan)\">BSM 7083865711 (Kesehatan)</option><option value=\"BSM 7083865878 (Dakwah dan Pendidikan)\">BSM 7083865878 (Dakwah dan Pendidikan)</option><option value=\"CIMB Niaga 7609 8688 0100 (zakat)\">CIMB Niaga 7609 8688 0100 (zakat)</option><option value=\"CIMB Niaga 7609 8687 1800 (Infaq dan Shadaqah)\">CIMB Niaga 7609 8687 1800 (Infaq dan Shadaqah)</option><option value=\"CIMB Niaga 7609 8687 6800 (Wakaf)\">CIMB Niaga 7609 8687 6800 (Wakaf)</option></select></li><li class=\"vfb-item vfb-item-file-upload  \" id=\"item-vfb-17\"><label for=\"vfb-17\" class=\"vfb-desc\">Lampiran Bukti Transfer </label><span class=\"vfb-span\"><input type=\"file\" name=\"vfb-17\" id=\"vfb-17\" value=\"\" class=\"vfb-text  vfb-medium     {accept:'png|jpe?g|gif'}\" /><label>Unggah Bukti Transfer Donasi Anda</label></span></li></ul>&nbsp;</fieldset><fieldset class=\"vfb-fieldset vfb-fieldset-2 verification \" id=\"item-vfb-2\" style=\"display:block\"><div class=\"vfb-legend\"><h3>Verification</h3></div><ul class=\"vfb-section vfb-section-2\"><li class=\"vfb-item vfb-item-secret\"  style=\"display:block\"><label for=\"vfb-3\" class=\"vfb-desc\">Please enter any two digits with no spaces (Example: 12) <span class=\"vfb-required-asterisk\">*</span></label><input type=\"hidden\" name=\"_vfb-secret\" value=\"vfb-3\" /><input type=\"text\" name=\"vfb-3\" id=\"vfb-3\" value=\"\" class=\"vfb-text  vfb-medium  required {digits:true,maxlength:2,minlength:2} \" style=\"display:block\" /><li style=\"display:none;\"><label>This box is for spam protection - <strong>please leave it blank</strong>:</label><div><input name=\"vfb-spam\" /></div></li> <li class=\"vfb-item vfb-item-submit\" id=\"item-vfb-4\"> <input type=\"submit\" name=\"vfb-submit\" id=\"vfb-4\" value=\"Kirim\" class=\"vfb-submit \" /> </li></ul> </fieldset><input type=\"hidden\" name=\"_wp_http_referer\" value=\"/api/get_recent_posts/\" /></form></div> <!-- .visual-form-builder-container --> ","");
       // textview_content.setText(Html.fromHtml(textCont));
        getSupportActionBar().setTitle(Html.fromHtml(text_title));

        URLImageParser p = new URLImageParser(textview_content,this);
        Spanned htmlSpan = Html.fromHtml(newString,p,null);

        textview_content.setText(htmlSpan);

        main_collapsing.setTitle(Html.fromHtml(text_title));


    }
}
