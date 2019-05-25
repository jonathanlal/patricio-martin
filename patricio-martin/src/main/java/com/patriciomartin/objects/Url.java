package com.patriciomartin.objects;

import java.lang.reflect.Field;

import com.patriciomartin.models.SendEmail;

public class Url {
	
	
	
	String jsp;
	String url_en;
	String url_es;
	
	
	public String getJsp() {
		return jsp;
	}
	public void setJsp(String jsp) {
		this.jsp = jsp;
	}
	public String getUrl_en() {
		return url_en;
	}
	public void setUrl_en(String url_en) {
		this.url_en = url_en;
	}
	public String getUrl_es() {
		return url_es;
	}
	public void setUrl_es(String url_es) {
		this.url_es = url_es;
	}
	
//	public Url(String jsp, Url... urls) {
//		//this wont work...
//		//this method needs to pass the jsp, url & url_alternative
//		this.jsp = jsp;
//		
//		 for (Url url : urls) 
//		    {
//			 String v = url_es; //url_es changes to anything,..
//			 this.v = url;
//		    }
//		//reflection here....
//	}
	
	//support for all languages
//	String url_aa;
//	String url_ab;
//	String url_ae;
//	String url_af;
//	String url_ak;
//	String url_am;
//	String url_an;
//	String url_ar;
//	String url_as;
//	String url_av;
//	String url_ay;
//	String url_az;
//	String url_ba;
//	String url_be;
//	String url_bg;
//	String url_bh;
//	String url_bm;
//	String url_bi;
//	String url_bn;
//	String url_bo;
//	String url_br;
//	String url_bs;
//	String url_ca;
//	String url_ce;
//	String url_ch;
//	String url_co;
//	String url_cr;
//	String url_cs;
//	String url_cu;
//	String url_cv;
//	String url_cy;
//	String url_da;
//	String url_de;
//	String url_dv;
//	String url_dz;
//	String url_ee;
//	String url_el;
//	String url_eo;
//	String url_et;
//	String url_eu;
//	String url_fa;
//	String url_ff;
//	String url_fi;
//	String url_fj;
//	String url_fo;
//	String url_fr;
//	String url_fy;
//	String url_ga;
//	String url_gd;
//	String url_gl;
//	String url_gn;
//	String url_gu;
//	String url_gv;
//	String url_ha;
//	String url_he;
//	String url_hi;
//	String url_ho;
//	String url_hr;
//	String url_ht;
//	String url_hu;
//	String url_hy;
//	String url_hz;
//	String url_ia;
//	String url_id;
//	String url_ie;
//	String url_ig;
//	String url_ii;
//	String url_ik;
//	String url_io;
//	String url_is;
//	String url_it;
//	String url_iu;
//	String url_ja;
//	String url_jv;
//	String url_ka;
//	String url_kg;
//	String url_ki;
//	String url_kj;
//	String url_kk;
//	String url_kl;
//	String url_km;
//	String url_kn;
//	String url_ko;
//	String url_kr;
//	String url_ks;
//	String url_ku;
//	String url_kv;
//	String url_kw;
//	String url_ky;
//	String url_la;
//	String url_lb;
//	String url_lg;
//	String url_li;
//	String url_ln;
//	String url_lo;
//	String url_lt;
//	String url_lu;
//	String url_lv;
//	String url_mg;
//	String url_mh;
//	String url_mi;
//	String url_mk;
//	String url_ml;
//	String url_mn;
//	String url_mr;
//	String url_ms;
//	String url_mt;
//	String url_my;
//	String url_na;
//	String url_nb;
//	String url_nd;
//	String url_ne;
//	String url_ng;
//	String url_nl;
//	String url_nn;
//	String url_no;
//	String url_nr;
//	String url_nv;
//	String url_ny;
//	String url_oc;
//	String url_oj;
//	String url_om;
//	String url_or;
//	String url_os;
//	String url_pa;
//	String url_pi;
//	String url_pl;
//	String url_ps;
//	String url_pt;
//	String url_qu;
//	String url_rm;
//	String url_rn;
//	String url_ro;
//	String url_ru;
//	String url_rw;
//	String url_sa;
//	String url_sc;
//	String url_sd;
//	String url_se;
//	String url_sg;
//	String url_si;
//	String url_sk;
//	String url_sl;
//	String url_sm;
//	String url_sn;
//	String url_so;
//	String url_sq;
//	String url_sr;
//	String url_ss;
//	String url_st;
//	String url_su;
//	String url_sv;
//	String url_sw;
//	String url_ta;
//	String url_te;
//	String url_tg;
//	String url_th;
//	String url_ti;
//	String url_tk;
//	String url_tl;
//	String url_tn;
//	String url_to;
//	String url_tr;
//	String url_ts;
//	String url_tt;
//	String url_tw;
//	String url_ty;
//	String url_ug;
//	String url_uk;
//	String url_ur;
//	String url_uz;
//	String url_ve;
//	String url_vi;
//	String url_vo;
//	String url_wa;
//	String url_wo;
//	String url_xh;
//	String url_yi;
//	String url_yo;
//	String url_za;
//	String url_zh;
//	String url_zu;
//	
//	
//	public String getJsp() {
//		return jsp;
//	}
//	public void setJsp(String jsp) {
//		this.jsp = jsp;
//	}
//	public String getUrl_aa() {
//		return url_aa;
//	}
//	public void setUrl_aa(String url_aa) {
//		this.url_aa = url_aa;
//	}
//	public String getUrl_ab() {
//		return url_ab;
//	}
//	public void setUrl_ab(String url_ab) {
//		this.url_ab = url_ab;
//	}
//	public String getUrl_ae() {
//		return url_ae;
//	}
//	public void setUrl_ae(String url_ae) {
//		this.url_ae = url_ae;
//	}
//	public String getUrl_af() {
//		return url_af;
//	}
//	public void setUrl_af(String url_af) {
//		this.url_af = url_af;
//	}
//	public String getUrl_ak() {
//		return url_ak;
//	}
//	public void setUrl_ak(String url_ak) {
//		this.url_ak = url_ak;
//	}
//	public String getUrl_am() {
//		return url_am;
//	}
//	public void setUrl_am(String url_am) {
//		this.url_am = url_am;
//	}
//	public String getUrl_an() {
//		return url_an;
//	}
//	public void setUrl_an(String url_an) {
//		this.url_an = url_an;
//	}
//	public String getUrl_ar() {
//		return url_ar;
//	}
//	public void setUrl_ar(String url_ar) {
//		this.url_ar = url_ar;
//	}
//	public String getUrl_as() {
//		return url_as;
//	}
//	public void setUrl_as(String url_as) {
//		this.url_as = url_as;
//	}
//	public String getUrl_av() {
//		return url_av;
//	}
//	public void setUrl_av(String url_av) {
//		this.url_av = url_av;
//	}
//	public String getUrl_ay() {
//		return url_ay;
//	}
//	public void setUrl_ay(String url_ay) {
//		this.url_ay = url_ay;
//	}
//	public String getUrl_az() {
//		return url_az;
//	}
//	public void setUrl_az(String url_az) {
//		this.url_az = url_az;
//	}
//	public String getUrl_ba() {
//		return url_ba;
//	}
//	public void setUrl_ba(String url_ba) {
//		this.url_ba = url_ba;
//	}
//	public String getUrl_be() {
//		return url_be;
//	}
//	public void setUrl_be(String url_be) {
//		this.url_be = url_be;
//	}
//	public String getUrl_bg() {
//		return url_bg;
//	}
//	public void setUrl_bg(String url_bg) {
//		this.url_bg = url_bg;
//	}
//	public String getUrl_bh() {
//		return url_bh;
//	}
//	public void setUrl_bh(String url_bh) {
//		this.url_bh = url_bh;
//	}
//	public String getUrl_bm() {
//		return url_bm;
//	}
//	public void setUrl_bm(String url_bm) {
//		this.url_bm = url_bm;
//	}
//	public String getUrl_bi() {
//		return url_bi;
//	}
//	public void setUrl_bi(String url_bi) {
//		this.url_bi = url_bi;
//	}
//	public String getUrl_bn() {
//		return url_bn;
//	}
//	public void setUrl_bn(String url_bn) {
//		this.url_bn = url_bn;
//	}
//	public String getUrl_bo() {
//		return url_bo;
//	}
//	public void setUrl_bo(String url_bo) {
//		this.url_bo = url_bo;
//	}
//	public String getUrl_br() {
//		return url_br;
//	}
//	public void setUrl_br(String url_br) {
//		this.url_br = url_br;
//	}
//	public String getUrl_bs() {
//		return url_bs;
//	}
//	public void setUrl_bs(String url_bs) {
//		this.url_bs = url_bs;
//	}
//	public String getUrl_ca() {
//		return url_ca;
//	}
//	public void setUrl_ca(String url_ca) {
//		this.url_ca = url_ca;
//	}
//	public String getUrl_ce() {
//		return url_ce;
//	}
//	public void setUrl_ce(String url_ce) {
//		this.url_ce = url_ce;
//	}
//	public String getUrl_ch() {
//		return url_ch;
//	}
//	public void setUrl_ch(String url_ch) {
//		this.url_ch = url_ch;
//	}
//	public String getUrl_co() {
//		return url_co;
//	}
//	public void setUrl_co(String url_co) {
//		this.url_co = url_co;
//	}
//	public String getUrl_cr() {
//		return url_cr;
//	}
//	public void setUrl_cr(String url_cr) {
//		this.url_cr = url_cr;
//	}
//	public String getUrl_cs() {
//		return url_cs;
//	}
//	public void setUrl_cs(String url_cs) {
//		this.url_cs = url_cs;
//	}
//	public String getUrl_cu() {
//		return url_cu;
//	}
//	public void setUrl_cu(String url_cu) {
//		this.url_cu = url_cu;
//	}
//	public String getUrl_cv() {
//		return url_cv;
//	}
//	public void setUrl_cv(String url_cv) {
//		this.url_cv = url_cv;
//	}
//	public String getUrl_cy() {
//		return url_cy;
//	}
//	public void setUrl_cy(String url_cy) {
//		this.url_cy = url_cy;
//	}
//	public String getUrl_da() {
//		return url_da;
//	}
//	public void setUrl_da(String url_da) {
//		this.url_da = url_da;
//	}
//	public String getUrl_de() {
//		return url_de;
//	}
//	public void setUrl_de(String url_de) {
//		this.url_de = url_de;
//	}
//	public String getUrl_dv() {
//		return url_dv;
//	}
//	public void setUrl_dv(String url_dv) {
//		this.url_dv = url_dv;
//	}
//	public String getUrl_dz() {
//		return url_dz;
//	}
//	public void setUrl_dz(String url_dz) {
//		this.url_dz = url_dz;
//	}
//	public String getUrl_ee() {
//		return url_ee;
//	}
//	public void setUrl_ee(String url_ee) {
//		this.url_ee = url_ee;
//	}
//	public String getUrl_el() {
//		return url_el;
//	}
//	public void setUrl_el(String url_el) {
//		this.url_el = url_el;
//	}
//	public String getUrl_en() {
//		return url_en;
//	}
//	public void setUrl_en(String url_en) {
//		this.url_en = url_en;
//	}
//	public String getUrl_eo() {
//		return url_eo;
//	}
//	public void setUrl_eo(String url_eo) {
//		this.url_eo = url_eo;
//	}
//	public String getUrl_es() {
//		return url_es;
//	}
//	public void setUrl_es(String url_es) {
//		this.url_es = url_es;
//	}
//	public String getUrl_et() {
//		return url_et;
//	}
//	public void setUrl_et(String url_et) {
//		this.url_et = url_et;
//	}
//	public String getUrl_eu() {
//		return url_eu;
//	}
//	public void setUrl_eu(String url_eu) {
//		this.url_eu = url_eu;
//	}
//	public String getUrl_fa() {
//		return url_fa;
//	}
//	public void setUrl_fa(String url_fa) {
//		this.url_fa = url_fa;
//	}
//	public String getUrl_ff() {
//		return url_ff;
//	}
//	public void setUrl_ff(String url_ff) {
//		this.url_ff = url_ff;
//	}
//	public String getUrl_fi() {
//		return url_fi;
//	}
//	public void setUrl_fi(String url_fi) {
//		this.url_fi = url_fi;
//	}
//	public String getUrl_fj() {
//		return url_fj;
//	}
//	public void setUrl_fj(String url_fj) {
//		this.url_fj = url_fj;
//	}
//	public String getUrl_fo() {
//		return url_fo;
//	}
//	public void setUrl_fo(String url_fo) {
//		this.url_fo = url_fo;
//	}
//	public String getUrl_fr() {
//		return url_fr;
//	}
//	public void setUrl_fr(String url_fr) {
//		this.url_fr = url_fr;
//	}
//	public String getUrl_fy() {
//		return url_fy;
//	}
//	public void setUrl_fy(String url_fy) {
//		this.url_fy = url_fy;
//	}
//	public String getUrl_ga() {
//		return url_ga;
//	}
//	public void setUrl_ga(String url_ga) {
//		this.url_ga = url_ga;
//	}
//	public String getUrl_gd() {
//		return url_gd;
//	}
//	public void setUrl_gd(String url_gd) {
//		this.url_gd = url_gd;
//	}
//	public String getUrl_gl() {
//		return url_gl;
//	}
//	public void setUrl_gl(String url_gl) {
//		this.url_gl = url_gl;
//	}
//	public String getUrl_gn() {
//		return url_gn;
//	}
//	public void setUrl_gn(String url_gn) {
//		this.url_gn = url_gn;
//	}
//	public String getUrl_gu() {
//		return url_gu;
//	}
//	public void setUrl_gu(String url_gu) {
//		this.url_gu = url_gu;
//	}
//	public String getUrl_gv() {
//		return url_gv;
//	}
//	public void setUrl_gv(String url_gv) {
//		this.url_gv = url_gv;
//	}
//	public String getUrl_ha() {
//		return url_ha;
//	}
//	public void setUrl_ha(String url_ha) {
//		this.url_ha = url_ha;
//	}
//	public String getUrl_he() {
//		return url_he;
//	}
//	public void setUrl_he(String url_he) {
//		this.url_he = url_he;
//	}
//	public String getUrl_hi() {
//		return url_hi;
//	}
//	public void setUrl_hi(String url_hi) {
//		this.url_hi = url_hi;
//	}
//	public String getUrl_ho() {
//		return url_ho;
//	}
//	public void setUrl_ho(String url_ho) {
//		this.url_ho = url_ho;
//	}
//	public String getUrl_hr() {
//		return url_hr;
//	}
//	public void setUrl_hr(String url_hr) {
//		this.url_hr = url_hr;
//	}
//	public String getUrl_ht() {
//		return url_ht;
//	}
//	public void setUrl_ht(String url_ht) {
//		this.url_ht = url_ht;
//	}
//	public String getUrl_hu() {
//		return url_hu;
//	}
//	public void setUrl_hu(String url_hu) {
//		this.url_hu = url_hu;
//	}
//	public String getUrl_hy() {
//		return url_hy;
//	}
//	public void setUrl_hy(String url_hy) {
//		this.url_hy = url_hy;
//	}
//	public String getUrl_hz() {
//		return url_hz;
//	}
//	public void setUrl_hz(String url_hz) {
//		this.url_hz = url_hz;
//	}
//	public String getUrl_ia() {
//		return url_ia;
//	}
//	public void setUrl_ia(String url_ia) {
//		this.url_ia = url_ia;
//	}
//	public String getUrl_id() {
//		return url_id;
//	}
//	public void setUrl_id(String url_id) {
//		this.url_id = url_id;
//	}
//	public String getUrl_ie() {
//		return url_ie;
//	}
//	public void setUrl_ie(String url_ie) {
//		this.url_ie = url_ie;
//	}
//	public String getUrl_ig() {
//		return url_ig;
//	}
//	public void setUrl_ig(String url_ig) {
//		this.url_ig = url_ig;
//	}
//	public String getUrl_ii() {
//		return url_ii;
//	}
//	public void setUrl_ii(String url_ii) {
//		this.url_ii = url_ii;
//	}
//	public String getUrl_ik() {
//		return url_ik;
//	}
//	public void setUrl_ik(String url_ik) {
//		this.url_ik = url_ik;
//	}
//	public String getUrl_io() {
//		return url_io;
//	}
//	public void setUrl_io(String url_io) {
//		this.url_io = url_io;
//	}
//	public String getUrl_is() {
//		return url_is;
//	}
//	public void setUrl_is(String url_is) {
//		this.url_is = url_is;
//	}
//	public String getUrl_it() {
//		return url_it;
//	}
//	public void setUrl_it(String url_it) {
//		this.url_it = url_it;
//	}
//	public String getUrl_iu() {
//		return url_iu;
//	}
//	public void setUrl_iu(String url_iu) {
//		this.url_iu = url_iu;
//	}
//	public String getUrl_ja() {
//		return url_ja;
//	}
//	public void setUrl_ja(String url_ja) {
//		this.url_ja = url_ja;
//	}
//	public String getUrl_jv() {
//		return url_jv;
//	}
//	public void setUrl_jv(String url_jv) {
//		this.url_jv = url_jv;
//	}
//	public String getUrl_ka() {
//		return url_ka;
//	}
//	public void setUrl_ka(String url_ka) {
//		this.url_ka = url_ka;
//	}
//	public String getUrl_kg() {
//		return url_kg;
//	}
//	public void setUrl_kg(String url_kg) {
//		this.url_kg = url_kg;
//	}
//	public String getUrl_ki() {
//		return url_ki;
//	}
//	public void setUrl_ki(String url_ki) {
//		this.url_ki = url_ki;
//	}
//	public String getUrl_kj() {
//		return url_kj;
//	}
//	public void setUrl_kj(String url_kj) {
//		this.url_kj = url_kj;
//	}
//	public String getUrl_kk() {
//		return url_kk;
//	}
//	public void setUrl_kk(String url_kk) {
//		this.url_kk = url_kk;
//	}
//	public String getUrl_kl() {
//		return url_kl;
//	}
//	public void setUrl_kl(String url_kl) {
//		this.url_kl = url_kl;
//	}
//	public String getUrl_km() {
//		return url_km;
//	}
//	public void setUrl_km(String url_km) {
//		this.url_km = url_km;
//	}
//	public String getUrl_kn() {
//		return url_kn;
//	}
//	public void setUrl_kn(String url_kn) {
//		this.url_kn = url_kn;
//	}
//	public String getUrl_ko() {
//		return url_ko;
//	}
//	public void setUrl_ko(String url_ko) {
//		this.url_ko = url_ko;
//	}
//	public String getUrl_kr() {
//		return url_kr;
//	}
//	public void setUrl_kr(String url_kr) {
//		this.url_kr = url_kr;
//	}
//	public String getUrl_ks() {
//		return url_ks;
//	}
//	public void setUrl_ks(String url_ks) {
//		this.url_ks = url_ks;
//	}
//	public String getUrl_ku() {
//		return url_ku;
//	}
//	public void setUrl_ku(String url_ku) {
//		this.url_ku = url_ku;
//	}
//	public String getUrl_kv() {
//		return url_kv;
//	}
//	public void setUrl_kv(String url_kv) {
//		this.url_kv = url_kv;
//	}
//	public String getUrl_kw() {
//		return url_kw;
//	}
//	public void setUrl_kw(String url_kw) {
//		this.url_kw = url_kw;
//	}
//	public String getUrl_ky() {
//		return url_ky;
//	}
//	public void setUrl_ky(String url_ky) {
//		this.url_ky = url_ky;
//	}
//	public String getUrl_la() {
//		return url_la;
//	}
//	public void setUrl_la(String url_la) {
//		this.url_la = url_la;
//	}
//	public String getUrl_lb() {
//		return url_lb;
//	}
//	public void setUrl_lb(String url_lb) {
//		this.url_lb = url_lb;
//	}
//	public String getUrl_lg() {
//		return url_lg;
//	}
//	public void setUrl_lg(String url_lg) {
//		this.url_lg = url_lg;
//	}
//	public String getUrl_li() {
//		return url_li;
//	}
//	public void setUrl_li(String url_li) {
//		this.url_li = url_li;
//	}
//	public String getUrl_ln() {
//		return url_ln;
//	}
//	public void setUrl_ln(String url_ln) {
//		this.url_ln = url_ln;
//	}
//	public String getUrl_lo() {
//		return url_lo;
//	}
//	public void setUrl_lo(String url_lo) {
//		this.url_lo = url_lo;
//	}
//	public String getUrl_lt() {
//		return url_lt;
//	}
//	public void setUrl_lt(String url_lt) {
//		this.url_lt = url_lt;
//	}
//	public String getUrl_lu() {
//		return url_lu;
//	}
//	public void setUrl_lu(String url_lu) {
//		this.url_lu = url_lu;
//	}
//	public String getUrl_lv() {
//		return url_lv;
//	}
//	public void setUrl_lv(String url_lv) {
//		this.url_lv = url_lv;
//	}
//	public String getUrl_mg() {
//		return url_mg;
//	}
//	public void setUrl_mg(String url_mg) {
//		this.url_mg = url_mg;
//	}
//	public String getUrl_mh() {
//		return url_mh;
//	}
//	public void setUrl_mh(String url_mh) {
//		this.url_mh = url_mh;
//	}
//	public String getUrl_mi() {
//		return url_mi;
//	}
//	public void setUrl_mi(String url_mi) {
//		this.url_mi = url_mi;
//	}
//	public String getUrl_mk() {
//		return url_mk;
//	}
//	public void setUrl_mk(String url_mk) {
//		this.url_mk = url_mk;
//	}
//	public String getUrl_ml() {
//		return url_ml;
//	}
//	public void setUrl_ml(String url_ml) {
//		this.url_ml = url_ml;
//	}
//	public String getUrl_mn() {
//		return url_mn;
//	}
//	public void setUrl_mn(String url_mn) {
//		this.url_mn = url_mn;
//	}
//	public String getUrl_mr() {
//		return url_mr;
//	}
//	public void setUrl_mr(String url_mr) {
//		this.url_mr = url_mr;
//	}
//	public String getUrl_ms() {
//		return url_ms;
//	}
//	public void setUrl_ms(String url_ms) {
//		this.url_ms = url_ms;
//	}
//	public String getUrl_mt() {
//		return url_mt;
//	}
//	public void setUrl_mt(String url_mt) {
//		this.url_mt = url_mt;
//	}
//	public String getUrl_my() {
//		return url_my;
//	}
//	public void setUrl_my(String url_my) {
//		this.url_my = url_my;
//	}
//	public String getUrl_na() {
//		return url_na;
//	}
//	public void setUrl_na(String url_na) {
//		this.url_na = url_na;
//	}
//	public String getUrl_nb() {
//		return url_nb;
//	}
//	public void setUrl_nb(String url_nb) {
//		this.url_nb = url_nb;
//	}
//	public String getUrl_nd() {
//		return url_nd;
//	}
//	public void setUrl_nd(String url_nd) {
//		this.url_nd = url_nd;
//	}
//	public String getUrl_ne() {
//		return url_ne;
//	}
//	public void setUrl_ne(String url_ne) {
//		this.url_ne = url_ne;
//	}
//	public String getUrl_ng() {
//		return url_ng;
//	}
//	public void setUrl_ng(String url_ng) {
//		this.url_ng = url_ng;
//	}
//	public String getUrl_nl() {
//		return url_nl;
//	}
//	public void setUrl_nl(String url_nl) {
//		this.url_nl = url_nl;
//	}
//	public String getUrl_nn() {
//		return url_nn;
//	}
//	public void setUrl_nn(String url_nn) {
//		this.url_nn = url_nn;
//	}
//	public String getUrl_no() {
//		return url_no;
//	}
//	public void setUrl_no(String url_no) {
//		this.url_no = url_no;
//	}
//	public String getUrl_nr() {
//		return url_nr;
//	}
//	public void setUrl_nr(String url_nr) {
//		this.url_nr = url_nr;
//	}
//	public String getUrl_nv() {
//		return url_nv;
//	}
//	public void setUrl_nv(String url_nv) {
//		this.url_nv = url_nv;
//	}
//	public String getUrl_ny() {
//		return url_ny;
//	}
//	public void setUrl_ny(String url_ny) {
//		this.url_ny = url_ny;
//	}
//	public String getUrl_oc() {
//		return url_oc;
//	}
//	public void setUrl_oc(String url_oc) {
//		this.url_oc = url_oc;
//	}
//	public String getUrl_oj() {
//		return url_oj;
//	}
//	public void setUrl_oj(String url_oj) {
//		this.url_oj = url_oj;
//	}
//	public String getUrl_om() {
//		return url_om;
//	}
//	public void setUrl_om(String url_om) {
//		this.url_om = url_om;
//	}
//	public String getUrl_or() {
//		return url_or;
//	}
//	public void setUrl_or(String url_or) {
//		this.url_or = url_or;
//	}
//	public String getUrl_os() {
//		return url_os;
//	}
//	public void setUrl_os(String url_os) {
//		this.url_os = url_os;
//	}
//	public String getUrl_pa() {
//		return url_pa;
//	}
//	public void setUrl_pa(String url_pa) {
//		this.url_pa = url_pa;
//	}
//	public String getUrl_pi() {
//		return url_pi;
//	}
//	public void setUrl_pi(String url_pi) {
//		this.url_pi = url_pi;
//	}
//	public String getUrl_pl() {
//		return url_pl;
//	}
//	public void setUrl_pl(String url_pl) {
//		this.url_pl = url_pl;
//	}
//	public String getUrl_ps() {
//		return url_ps;
//	}
//	public void setUrl_ps(String url_ps) {
//		this.url_ps = url_ps;
//	}
//	public String getUrl_pt() {
//		return url_pt;
//	}
//	public void setUrl_pt(String url_pt) {
//		this.url_pt = url_pt;
//	}
//	public String getUrl_qu() {
//		return url_qu;
//	}
//	public void setUrl_qu(String url_qu) {
//		this.url_qu = url_qu;
//	}
//	public String getUrl_rm() {
//		return url_rm;
//	}
//	public void setUrl_rm(String url_rm) {
//		this.url_rm = url_rm;
//	}
//	public String getUrl_rn() {
//		return url_rn;
//	}
//	public void setUrl_rn(String url_rn) {
//		this.url_rn = url_rn;
//	}
//	public String getUrl_ro() {
//		return url_ro;
//	}
//	public void setUrl_ro(String url_ro) {
//		this.url_ro = url_ro;
//	}
//	public String getUrl_ru() {
//		return url_ru;
//	}
//	public void setUrl_ru(String url_ru) {
//		this.url_ru = url_ru;
//	}
//	public String getUrl_rw() {
//		return url_rw;
//	}
//	public void setUrl_rw(String url_rw) {
//		this.url_rw = url_rw;
//	}
//	public String getUrl_sa() {
//		return url_sa;
//	}
//	public void setUrl_sa(String url_sa) {
//		this.url_sa = url_sa;
//	}
//	public String getUrl_sc() {
//		return url_sc;
//	}
//	public void setUrl_sc(String url_sc) {
//		this.url_sc = url_sc;
//	}
//	public String getUrl_sd() {
//		return url_sd;
//	}
//	public void setUrl_sd(String url_sd) {
//		this.url_sd = url_sd;
//	}
//	public String getUrl_se() {
//		return url_se;
//	}
//	public void setUrl_se(String url_se) {
//		this.url_se = url_se;
//	}
//	public String getUrl_sg() {
//		return url_sg;
//	}
//	public void setUrl_sg(String url_sg) {
//		this.url_sg = url_sg;
//	}
//	public String getUrl_si() {
//		return url_si;
//	}
//	public void setUrl_si(String url_si) {
//		this.url_si = url_si;
//	}
//	public String getUrl_sk() {
//		return url_sk;
//	}
//	public void setUrl_sk(String url_sk) {
//		this.url_sk = url_sk;
//	}
//	public String getUrl_sl() {
//		return url_sl;
//	}
//	public void setUrl_sl(String url_sl) {
//		this.url_sl = url_sl;
//	}
//	public String getUrl_sm() {
//		return url_sm;
//	}
//	public void setUrl_sm(String url_sm) {
//		this.url_sm = url_sm;
//	}
//	public String getUrl_sn() {
//		return url_sn;
//	}
//	public void setUrl_sn(String url_sn) {
//		this.url_sn = url_sn;
//	}
//	public String getUrl_so() {
//		return url_so;
//	}
//	public void setUrl_so(String url_so) {
//		this.url_so = url_so;
//	}
//	public String getUrl_sq() {
//		return url_sq;
//	}
//	public void setUrl_sq(String url_sq) {
//		this.url_sq = url_sq;
//	}
//	public String getUrl_sr() {
//		return url_sr;
//	}
//	public void setUrl_sr(String url_sr) {
//		this.url_sr = url_sr;
//	}
//	public String getUrl_ss() {
//		return url_ss;
//	}
//	public void setUrl_ss(String url_ss) {
//		this.url_ss = url_ss;
//	}
//	public String getUrl_st() {
//		return url_st;
//	}
//	public void setUrl_st(String url_st) {
//		this.url_st = url_st;
//	}
//	public String getUrl_su() {
//		return url_su;
//	}
//	public void setUrl_su(String url_su) {
//		this.url_su = url_su;
//	}
//	public String getUrl_sv() {
//		return url_sv;
//	}
//	public void setUrl_sv(String url_sv) {
//		this.url_sv = url_sv;
//	}
//	public String getUrl_sw() {
//		return url_sw;
//	}
//	public void setUrl_sw(String url_sw) {
//		this.url_sw = url_sw;
//	}
//	public String getUrl_ta() {
//		return url_ta;
//	}
//	public void setUrl_ta(String url_ta) {
//		this.url_ta = url_ta;
//	}
//	public String getUrl_te() {
//		return url_te;
//	}
//	public void setUrl_te(String url_te) {
//		this.url_te = url_te;
//	}
//	public String getUrl_tg() {
//		return url_tg;
//	}
//	public void setUrl_tg(String url_tg) {
//		this.url_tg = url_tg;
//	}
//	public String getUrl_th() {
//		return url_th;
//	}
//	public void setUrl_th(String url_th) {
//		this.url_th = url_th;
//	}
//	public String getUrl_ti() {
//		return url_ti;
//	}
//	public void setUrl_ti(String url_ti) {
//		this.url_ti = url_ti;
//	}
//	public String getUrl_tk() {
//		return url_tk;
//	}
//	public void setUrl_tk(String url_tk) {
//		this.url_tk = url_tk;
//	}
//	public String getUrl_tl() {
//		return url_tl;
//	}
//	public void setUrl_tl(String url_tl) {
//		this.url_tl = url_tl;
//	}
//	public String getUrl_tn() {
//		return url_tn;
//	}
//	public void setUrl_tn(String url_tn) {
//		this.url_tn = url_tn;
//	}
//	public String getUrl_to() {
//		return url_to;
//	}
//	public void setUrl_to(String url_to) {
//		this.url_to = url_to;
//	}
//	public String getUrl_tr() {
//		return url_tr;
//	}
//	public void setUrl_tr(String url_tr) {
//		this.url_tr = url_tr;
//	}
//	public String getUrl_ts() {
//		return url_ts;
//	}
//	public void setUrl_ts(String url_ts) {
//		this.url_ts = url_ts;
//	}
//	public String getUrl_tt() {
//		return url_tt;
//	}
//	public void setUrl_tt(String url_tt) {
//		this.url_tt = url_tt;
//	}
//	public String getUrl_tw() {
//		return url_tw;
//	}
//	public void setUrl_tw(String url_tw) {
//		this.url_tw = url_tw;
//	}
//	public String getUrl_ty() {
//		return url_ty;
//	}
//	public void setUrl_ty(String url_ty) {
//		this.url_ty = url_ty;
//	}
//	public String getUrl_ug() {
//		return url_ug;
//	}
//	public void setUrl_ug(String url_ug) {
//		this.url_ug = url_ug;
//	}
//	public String getUrl_uk() {
//		return url_uk;
//	}
//	public void setUrl_uk(String url_uk) {
//		this.url_uk = url_uk;
//	}
//	public String getUrl_ur() {
//		return url_ur;
//	}
//	public void setUrl_ur(String url_ur) {
//		this.url_ur = url_ur;
//	}
//	public String getUrl_uz() {
//		return url_uz;
//	}
//	public void setUrl_uz(String url_uz) {
//		this.url_uz = url_uz;
//	}
//	public String getUrl_ve() {
//		return url_ve;
//	}
//	public void setUrl_ve(String url_ve) {
//		this.url_ve = url_ve;
//	}
//	public String getUrl_vi() {
//		return url_vi;
//	}
//	public void setUrl_vi(String url_vi) {
//		this.url_vi = url_vi;
//	}
//	public String getUrl_vo() {
//		return url_vo;
//	}
//	public void setUrl_vo(String url_vo) {
//		this.url_vo = url_vo;
//	}
//	public String getUrl_wa() {
//		return url_wa;
//	}
//	public void setUrl_wa(String url_wa) {
//		this.url_wa = url_wa;
//	}
//	public String getUrl_wo() {
//		return url_wo;
//	}
//	public void setUrl_wo(String url_wo) {
//		this.url_wo = url_wo;
//	}
//	public String getUrl_xh() {
//		return url_xh;
//	}
//	public void setUrl_xh(String url_xh) {
//		this.url_xh = url_xh;
//	}
//	public String getUrl_yi() {
//		return url_yi;
//	}
//	public void setUrl_yi(String url_yi) {
//		this.url_yi = url_yi;
//	}
//	public String getUrl_yo() {
//		return url_yo;
//	}
//	public void setUrl_yo(String url_yo) {
//		this.url_yo = url_yo;
//	}
//	public String getUrl_za() {
//		return url_za;
//	}
//	public void setUrl_za(String url_za) {
//		this.url_za = url_za;
//	}
//	public String getUrl_zh() {
//		return url_zh;
//	}
//	public void setUrl_zh(String url_zh) {
//		this.url_zh = url_zh;
//	}
//	public String getUrl_zu() {
//		return url_zu;
//	}
//	public void setUrl_zu(String url_zu) {
//		this.url_zu = url_zu;
//	}

	
	
}
