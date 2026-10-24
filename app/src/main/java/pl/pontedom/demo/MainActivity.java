package pl.pontedom.demo;
import android.app.*;import android.os.*;import android.content.*;import android.graphics.Color;import android.view.*;import android.webkit.*;import android.widget.*;import android.net.Uri;
public class MainActivity extends Activity {
 WebView web; ProgressBar progress;
 @Override public void onCreate(Bundle state){super.onCreate(state);
 LinearLayout root=new LinearLayout(this);root.setOrientation(LinearLayout.VERTICAL);root.setBackgroundColor(Color.WHITE);
 progress=new ProgressBar(this,null,android.R.attr.progressBarStyleHorizontal);progress.setMax(100);root.addView(progress,new LinearLayout.LayoutParams(-1,5));
 web=new WebView(this);root.addView(web,new LinearLayout.LayoutParams(-1,0,1));setContentView(root);
 WebSettings s=web.getSettings();s.setJavaScriptEnabled(true);s.setDomStorageEnabled(true);s.setAllowFileAccess(false);s.setJavaScriptCanOpenWindowsAutomatically(false);s.setSupportZoom(true);
 web.setWebChromeClient(new WebChromeClient(){@Override public void onProgressChanged(WebView v,int p){progress.setProgress(p);progress.setVisibility(p==100?View.GONE:View.VISIBLE);}});
 web.setWebViewClient(new WebViewClient(){@Override public boolean shouldOverrideUrlLoading(WebView v,WebResourceRequest r){Uri u=r.getUrl();String scheme=u.getScheme();if(("https".equals(scheme)||"http".equals(scheme)) && ("pontedom.pl".equalsIgnoreCase(u.getHost())||"www.pontedom.pl".equalsIgnoreCase(u.getHost())))return false;try{startActivity(new Intent(Intent.ACTION_VIEW,u));}catch(Exception e){Toast.makeText(MainActivity.this,"No app can open this link",Toast.LENGTH_SHORT).show();}return true;}});
 if(state!=null)web.restoreState(state);else web.loadUrl("https://pontedom.pl/"); }
 @Override protected void onSaveInstanceState(Bundle out){web.saveState(out);super.onSaveInstanceState(out);}
 @Override public void onBackPressed(){if(web.canGoBack())web.goBack();else super.onBackPressed();}
}