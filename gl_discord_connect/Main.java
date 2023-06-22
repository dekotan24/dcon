/* Discord connector Version 1.51
 * Game Launcher C# Edition Version.0.942 or higher
 * 
 * Author	: Ogura Deko (dekosoft)
 * E-Mail	: deko@fanet.work
 * WebSite	: https://fanet.work
 * RPC		: https://github.com/MinnDevelopment/java-discord-rpc
 * 
 * .:: Change log ::.
 * Version 1.0	���񃊃��[�X
 * Version 1.1	�ꕔ�̃Q�[���A�C�R�����T�|�[�g
 * Version 1.2	�ꕔ�̃Q�[���A�C�R�����T�|�[�g
 * Version 1.3	�A�v���^�C�g���̕\�������P
 * Version 1.3.1
 * Version 1.3.2 200513 �ꕔ�̃Q�[���A�C�R���̃T�|�[�g
 * Version 1.3.3 200605 AI�������T�|�[�g
 * Version 1.3.4 200714 �A�i�x�����C�h�K�[�f���A�n�j�[�Z���N�g2RBD�̃T�|�[�g
 * Version 1.3.5 200804 glc_cs�ɑΉ�
 * Version 1.41 200815 �������OHS�A�v���e�B�P�A�v���e�B�P2�̃T�|�[�g
 * Version 1.42 200817 hidden�T�|�[�g
 * Version 1.43 200916 ����Ƃ��A�t�t���W���C���A���܂��܃V�F�A�����O�A�v�����Z�X�n�[�g�����N�A�����ʂ��t�X�p�[�L���O�A����X�v�����N���̃T�|�[�g
 * Version 1.44 200928 �n�~�N���A�Z���V�e�B�u���[�h2�̃T�|�[�g
 * Version 1.45 201101 pieces / �n�蒹�̃\���j�E���Apieces / �h���ẴJ�i���A�A���P���[���炢�ӁA�˂��c�N�A������B�A�V�X���L�����̃T�|�[�g�B
 * 						���쌠�\���ɑΉ��B�R�����g�A�E�g��title��null�̎��ɏI�����Ȃ������C��
 * Version 1.46 201219 �R�C�J�c�T�|�[�g
 * Version 1.47 201226 �h�[�i�h�[�i�T�|�[�g
 * Version 1.48 210425 9-nine-�T�|�[�g
 * Version 1.49 210830 �R�C�J�c �T���V���C�� �T�|�[�g
 * Version 1.50 220918 �O���A�v���P�[�V�����ɑΉ�
 * Version 1.51 230622 �V�g�����X RE-BOOT!���T�|�[�g�Bdcon�̓��I�t�@�C�����ɑΉ��B
 */

package gl_discord_connect;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.Properties;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;

public class Main {

	public static void main(String[] args) throws URISyntaxException {

		String titledata = "";
		String cstat = null;
		String dconver = "Ver.1.51��230622";
		String originAppID = "617680312549376003";
		String appID = "";
		String appIconID = "";

    	// ���s����jar�t�@�C���̃p�X���擾
    	String jarPath = new java.io.File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getAbsolutePath();
    	// �p�X����t�@�C���������𒊏o
    	String jarName = jarPath.substring(jarPath.lastIndexOf(java.io.File.separator) + 1);
    	System.out.println(jarName);
    	// �����J�E���g
    	int pathlen = jarName.length();
    	
    	// ���s�p�X�̎擾�ƍ�ƃf�B���N�g���p�X�̎擾
    	Path path = getApplicationPath(Main.class);
    	StringBuilder sb = new StringBuilder(path.toString());
    	sb.setLength(sb.length()-pathlen);
    	
		String exePath = String.valueOf(path.toString()) + "\\";
		System.out.println("[ExePath]: " + exePath);

		// �v���p�e�B�t�@�C���p�X�̎擾
		Properties prop = new Properties();
		String strpath = sb.toString() + "run.properties";
		System.out.println(strpath);
		
		// �e��f�[�^�̎擾
		try
		{
			InputStream istream = new FileInputStream(strpath);
			InputStreamReader isr = new InputStreamReader(istream, "Shift-JIS");
			prop.load(isr);

			titledata = prop.getProperty("title") == null ? "" : prop.getProperty("title");
			cstat = prop.getProperty("stat") == null ? "" : prop.getProperty("stat");
			appID = prop.getProperty("appid") == null ? "" : prop.getProperty("appid");
			appIconID = prop.getProperty("appicon") == null ? "" : prop.getProperty("appicon");
			
			istream.close();
		}
		catch (IOException e)
		{
				e.printStackTrace();
		}

		System.out.println("[Recieve Title]: " + titledata);
		System.out.println("[Recieve cStat]: " + cstat);
		System.out.println("[Recieve AppID]: " + appID);
		System.out.println("[Recieve AppIconID]: " + titledata);
		if (titledata == "" || titledata == null) {
			System.exit(0);
		}

		// �A�C�R���ݒ�֌W
		String favicon = "fav";
		String subicon = null;
		String copyrgt = null;

		// copyright
		String c_los 		= 	"Lump of Sugar";
		String c_wp 		= 	"Whirlpool";
		String c_onmtp 		= 	"onomatope��raspberry";
		String c_ms 		= 	"�܂ǂ��ӂ�";
		String c_sgpr 		= 	"SAGA PLANETS";
		String c_rsk		= 	"��������";
		String c_pencil 	= 	"PENCIL";
		String c_purple 	= 	"Purple software";
		String c_cra 		= 	"CourregesA";
		String c_hibiki 	= 	"hibiki works";
		String c_illusion 	= 	"illusion";
		String c_bl 		= 	"Barista Lab";
		String c_akabei3 	= 	"AKABEi SOFT3";
		String c_mc 		= 	"Mint CUBE";
		String c_zion 		= 	"ZION";
		String c_prcn 		= 	"�v���J�m";
		String c_hachi 		= 	"hachimitsu_soft";
		String c_wp_pt 		= 	"WillPlus/PULLTOP";
		String c_feng 		= 	"feng";
		String c_milk 		= 	"�݂邭�ӂ����Ƃ�[";
		String c_ribidoh 	= 	"��тǁ[���ӂ�";
		String c_campus 	= 	"Campus";
		String c_eufo 		= 	"eufonie";
		String c_azrs 		= 	"AZARASHI SOFTWARE";
		String c_mirai 		= 	"mirai";
		String c_sp 		= 	"SILKYS PLUS";
		String c_smile 		= 	"�X�~��";
		String c_yuzu 		= 	"YUZUSOFT / JUNOS inc.";
		String c_saga 		= 	"SAGA PLANETS";
		String c_hearts 	= 	"Hearts/AMUSE CRAFT";
		String c_op 		= 	"onepoint";
		String c_smee 		= 	"SMEE";
		String c_crys 		= 	"CRYSTALiA/AMUSE CRAFT";
		String c_marede 	= 	"MARMALADE";
		String c_palette 	= 	"CLEARRAVE / PALETTE";
		String c_sirokuma 	= 	"���낭�܂���";
		String c_sprite 	= 	"sprite/fairys";
		String c_qruppo 	= 	"Qruppo";
		String c_pm 		= 	"PIXEL MINT";
		String c_harukaze 	= 	"HARUKAZE";
		String c_key 		= 	"VISUAL ARTS / Key";
		String c_paletteq 	= 	"CLEARRAVE / PALETTE-QUALIA";
		String c_alicesoft 	= 	"ALICESOFT";

		// �Q�[���ꗗ
		String hidden 		= 	"hidden";
		String hidden2 		= 	"Unknown";
		String tomedome 	= 	"�I�g�����h���C��";
		String noratoto 	= 	"�m���ƍc���Ɩ�ǔL�n�[�g";
		String noratoto2 	= 	"�m���ƍc���Ɩ�ǔL�n�[�g�Q";
		String kokorog 		= 	"�i�c�C���R�R�����O";
		  String kokorog_hs = 	"Happy Summer";
		String sp 			= 	"Summer Pockets";
		String wq 			= 	"��t�F�̃J���e�b�g";
		String yorikure 	= 	"����č��̗t�͍g��";
		String po 			= 	"�ς炾�������`�����";
		String nukitasi 	= 	"�����Q�[�݂����ȓ��ɏZ��ł�n���͂ǂ�����Ⴂ���ł���";
		String hanasaki 	= 	"�ԍ烏�[�N�X�v�����O";
		String aokana 		= 	"���̔ޕ��̃t�H�[���Y��";
		String im 			= 	"�����̏��_�̎�����";
		String kkk 			= 	"�����̂����̂������̂���";
		String sss 			= 	"���炢�낻�炤������̂���";
		String hhh 			= 	"�͂邢��͂邱���͂�̂���";
		String yyy			= 	"�䂫����䂫�͂Ȃ䂫�̂���";
		String nineallage	= 	"9-nine-";
		String mashimaro 	= 	"���ƂɋA��܂ł��܂��܂�ł�";
		String rc 			= 	"���Y�x���[�L���[�u";
		String yakisuto 	= 	"���L���`�X�g���[��";
		String wagahigh 	= 	"���K�}�}�n�C�X�y�b�N";
		String wagahighoc 	= 	"���K�}�}�n�C�X�y�b�NOC";
		String mekuiro	 	= 	"�J����߂��������";
		String ml			= 	"Making��Lovers";
		String ss			= 	"Sugar��Style";
		String koicha 		= 	"�����̂����C�`���R���C�Y";
		String koikoro 		= 	"������R�R���Ɩ��@�̃R�g�o";
		String nukitasi2 	= 	"�����Q�[�݂����ȓ��ɏZ��ł�n���͂ǂ�����Ⴂ���ł����H�Q";
		String kinkoi 		= 	"���F���u���b�`�F";
		String kinkoi2 		= 	"���F���u���b�`�F-GoldenTime-";
		String riddlejoker 	= 	"RIDDLE JOKER";
		String sabofwitch 	= 	"�T�m�o�E�B�b�`";
		String senrenbanka 	= 	"���������";
		String sutera 		= 	"�i���X�e���Ǝ��_�̒�";
		String tenshisz		=	"�V�g�����X RE-BOOT!";
		String koikuma 		= 	"�l�Ɨ�����|���R�c�A�N�}�B";
		String koikuma2 	= 	"�l�Ɨ�����|���R�c�A�N�}�B���������������I";
		String kimaten 		= 	"���܂���e���v�e�[�V����";
		String syukugar1	= 	"�h���̃K�[���t�����h";
		String syukugar2 	= 	"�h���̃K�[���t�����h�Q";
		String syukugar3 	= 	"�h���̃K�[���t�����h�R";
		String syukugar4 	= 	"�h���̃K�[���t�����h �����q��";
		String aikagiad 	= 	"�A�t�^�[�f�C�Y";
		String aikagi 		= 	"�A�C�J�M";
		String hanidevi 	= 	"�͂Ƀf�r";
		String sepiarche 	= 	"�����Z�E�s�A�[�`�F";
		String hinekure 	= 	"�P���ꃂ�m�̊w���t����";
		String mhh			= 	"�����ƁI�s�܂��I���̂����ς��ِ��E�G�����@�w���I";
		String yumeiro 		= 	"���ƐF�łł��Ă���";
		String sakurairo 	= 	"�����炢��A���������";
		String icing 		= 	"�A�C�V���O-love coating-";
		String oniama 		= 	"���ɂ���";
		String noer 		= 	"�����V�g�m�G��";
		String majocafe 	= 	"�E�҂Ɩ����ƁA�����̃J�t�F";
		String renaijijo 	= 	"�����I�g�i�̗�������";
		String renaijijo2 	= 	"�����I�g�i�̗�������Q";
		String aisyoujyo 	= 	"AI������";
		String amg 			= 	"�A�i�x���E���C�h�K�[�f��";
		String hs2rbd 		= 	"�n�j�[�Z���N�g2";
		String prettycation = 	"�o�q�d�s�s�x�~�b�Ȃs�h�n�m";
		String prettycation2 = 	"�o�q�d�s�s�x�~�b�Ȃs�h�n�m�Q";
		String entomo 		=	"����Ƃ�";
		String fragile 		= 	"�t�t���W���C��";
		String amasharing 	= 	"���܂��܃V�F�A�����O";
		String phl 			= 	"�v�����Z�X�n�[�g�����N";
		String kakenuke 	= 	"�����ʂ����t�X�p�[�L���O�I";
		String hatsujo 		= 	"����X�v�����N��";
		String hamidashi 	= 	"�n�~�_�V�N���G�C�e�B�u";
		String drapri 		= 	"���P���[���炢��";
		String nekotsuku 	= 	"�˂��c�N�A������B";
		String siscan 		= 	"�V�X���L����";
		String piecies 		= 	"pieces";
		  String somnium 	= 	"�n�蒹�̃\���j�E��";
		  String canary 	= 	"�h���ẴJ�i���A";
	  	String koikatu 		= 	"�R�C�J�c";
	  		String koikatu_	= 	"Koikatu";
	  	String koikatu_ss	=	"�R�C�J�c �T���V���C��";
	  	String dohnadohna 	= 	"�h�[�i�h�[�i ��������ɂ�邢���Ƃ����悤";

		if(titledata.contains(hidden) || titledata.contains(hidden2)) {
			subicon = "fav";
			favicon = "hidden";
		}else if(titledata.contains(tomedome)) {
			subicon = "fav";
			favicon = "tomedome";
			copyrgt = c_paletteq;
		}else if(titledata.contains(sp)) {
			subicon = "fav";
			favicon = "sp";
			copyrgt = c_key;
		}else if(titledata.contains(noratoto2)) {
			subicon = "fav";
			favicon = "noratoto2";
			copyrgt = c_harukaze;
		}else if(titledata.contains(noratoto)) {
			subicon = "fav";
			favicon = "noratoto";
			copyrgt = c_harukaze;
		}else if(titledata.contains(wq)) {
			subicon = "fav";
			favicon = "wq";
			copyrgt = c_los;
		}else if(titledata.contains(kokorog) && titledata.contains(kokorog_hs)) {
			subicon = "fav";
			favicon = "kokorog_hs";
			copyrgt = c_hearts;
		}else if(titledata.contains(kokorog)) {
			subicon = "fav";
			favicon = "kokorog";
			copyrgt = c_hearts;
		}else if(titledata.contains(yorikure)) {
			subicon = "fav";
			favicon = "yorikure";
			copyrgt = c_los;
		}else if(titledata.contains(po)) {
			subicon = "fav";
			favicon = "po";
			copyrgt = c_pm;
		}else if(titledata.contains(nukitasi2)) {
			subicon = "fav";
			favicon = "nukitasi2";
			copyrgt = c_qruppo;
		}else if(titledata.contains(nukitasi)) {
			subicon = "fav";
			favicon = "nukitashi";
			copyrgt = c_qruppo;
		}else if(titledata.contains(hanasaki)) {
			subicon = "fav";
			favicon = "hanasaki";
			copyrgt = c_saga;
		}else if(titledata.contains(aokana)) {
			subicon = "fav";
			favicon = "aokana";
			copyrgt = c_sprite;
		}else if(titledata.contains(im)){
			subicon = "fav";
			favicon = "im";
			copyrgt = c_sirokuma;
		}else if(titledata.contains(kkk)) {
			subicon = "fav";
			favicon = "kokoiro";
			copyrgt = c_palette;
		}else if(titledata.contains(sss)) {
			subicon = "fav";
			favicon = "sorairo";
			copyrgt = c_palette;
		}else if(titledata.contains(hhh)) {
			subicon = "fav";
			favicon = "haruiro";
			copyrgt = c_palette;
		}else if(titledata.contains(yyy)) {
			subicon = "fav";
			favicon = "yukiiro";
			copyrgt = c_palette;
		}else if(titledata.contains(nineallage)) {
			subicon = "fav";
			favicon = "nineallage";
			copyrgt = c_palette;
		}else if(titledata.contains(mashimaro)) {
			subicon = "fav";
			favicon = "mashimaro";
			copyrgt = c_marede;
		}else if(titledata.contains(rc)) {
			subicon = "fav";
			favicon = "raspberrycube";
			copyrgt = c_ms;
		}else if(titledata.contains(yakisuto)) {
			subicon = "fav";
			favicon = "yakisuto";
			copyrgt = c_ms;
		}else if(titledata.contains(wagahighoc)) {
			subicon = "fav";
			favicon = "wagahigh2";
			copyrgt = c_ms;
		}else if(titledata.contains(wagahigh)) {
			subicon = "fav";
			favicon = "wagahigh";
			copyrgt = c_ms;
		}else if(titledata.contains(mekuiro)) {
			subicon = "fav";
			favicon = "mekuiro";
			copyrgt = c_crys;
		}else if(titledata.contains(ml)) {
			subicon = "fav";
			favicon = "ml";
			copyrgt = c_smee;
		}else if(titledata.contains(ss)) {
			subicon = "fav";
			favicon = "ss";
			copyrgt = c_smee;
		}else if(titledata.contains(koicha)) {
			subicon = "fav";
			favicon = "koicha";
			copyrgt = c_op;
		}else if(titledata.contains(koikoro)) {
			subicon = "fav";
			favicon = "koikoro";
			copyrgt = c_hearts;
		}else if(titledata.contains(kinkoi2)) {
			subicon = "fav";
			favicon = "kinkoi2";
			copyrgt = c_saga;
		}else if(titledata.contains(kinkoi)) {
			subicon = "fav";
			favicon = "kinkoi";
			copyrgt = c_saga;
		}else if(titledata.contains(riddlejoker)) {
			subicon = "fav";
			favicon = "yuzusoft";
			copyrgt = c_yuzu;
		}else if(titledata.contains(sabofwitch)) {
			subicon = "fav";
			favicon = "yuzusoft";
			copyrgt = c_yuzu;
		}else if(titledata.contains(senrenbanka)) {
			subicon = "fav";
			favicon = "yuzusoft";
			copyrgt = c_yuzu;
		}else if(titledata.contains(sutera)) {
			subicon = "fav";
			favicon = "yuzusoft";
			copyrgt = c_yuzu;
		}else if(titledata.contains(tenshisz)) {
			subicon = "fav";
			favicon = "yuzusoft";
			copyrgt = c_yuzu;
		}else if(titledata.contains(koikuma2)) {
			subicon = "fav";
			favicon = "koikuma2";
			copyrgt = c_smile;
		}else if(titledata.contains(koikuma)) {
			subicon = "fav";
			favicon = "koikuma";
			copyrgt = c_smile;
		}else if(titledata.contains(kimaten)) {
			subicon = "fav";
			favicon = "kimaten";
			copyrgt = c_sp;
		}else if(titledata.contains(syukugar4)) {
			subicon = "fav";
			favicon = "syukugar4";
			copyrgt = c_mirai;
		}else if(titledata.contains(syukugar3)) {
			subicon = "fav";
			favicon = "syukugar3";
			copyrgt = c_mirai;
		}else if(titledata.contains(syukugar2)) {
			subicon = "fav";
			favicon = "syukugar2";
			copyrgt = c_mirai;
		}else if(titledata.contains(syukugar1)) {
			subicon = "fav";
			favicon = "syukugar1";
			copyrgt = c_mirai;
		}else if(titledata.contains(aikagi) && titledata.contains(aikagiad)) {
			subicon = "fav";
			favicon = "aikagiad";
			copyrgt = c_azrs;
		}else if(titledata.contains(aikagi)) {
			subicon = "fav";
			favicon = "aikagi";
			copyrgt = c_azrs;
		}else if(titledata.contains(hanidevi)) {
			subicon = "fav";
			favicon = "hanidevi";
			copyrgt = c_eufo;
		}else if(titledata.contains(sepiarche)) {
			subicon = "fav";
			favicon = "sepiarche";
			copyrgt = c_campus;
		}else if(titledata.contains(hinekure)) {
			subicon = "fav";
			favicon = "hinekure";
			copyrgt = c_ribidoh;
		}else if(titledata.contains(mhh)) {
			subicon = "fav";
			favicon = "mhh";
			copyrgt = c_milk;
		}else if(titledata.contains(yumeiro)) {
			subicon = "fav";
			favicon = "yumeiro";
			copyrgt = c_feng;
		}else if(titledata.contains(sakurairo)) {
			subicon = "fav";
			favicon = "sakurairo";
			copyrgt = c_wp_pt;
		}else if(titledata.contains(icing)) {
			subicon = "fav";
			favicon = "icing";
			copyrgt = c_hachi;
		}else if(titledata.contains(oniama)) {
			subicon = "fav";
			favicon = "oniama";
			copyrgt = c_prcn;
		}else if(titledata.contains(noer)) {
			subicon = "fav";
			favicon = "noer";
			copyrgt = c_zion;
		}else if(titledata.contains(majocafe)) {
			subicon = "fav";
			favicon = "majocafe";
			copyrgt = c_mc;
		}else if(titledata.contains(renaijijo2)) {
			subicon = "fav";
			favicon = "renaijijo2";
			copyrgt = c_akabei3;
		}else if(titledata.contains(renaijijo)) {
			subicon = "fav";
			favicon = "renaijijo";
			copyrgt = c_akabei3;
		}else if(titledata.contains(aisyoujyo)) {
			subicon = "fav";
			favicon = "ais";
			copyrgt = c_illusion;
		}else if(titledata.contains(amg)) {
			subicon = "fav";
			favicon = "amg";
			copyrgt = c_bl;
		}else if(titledata.contains(hs2rbd)) {
			subicon = "fav";
			favicon = "hs2rbd";
			copyrgt = c_illusion;
		}else if(titledata.contains(prettycation2)) {
			subicon = "fav";
			favicon = "pc2";
			copyrgt = c_hibiki;
		}else if(titledata.contains(prettycation)) {
			subicon = "fav";
			favicon = "pc";
			copyrgt = c_hibiki;
		}else if(titledata.contains(entomo)) {
			subicon = "fav";
			favicon = "entomo";
			copyrgt = c_cra;
		}else if(titledata.contains(fragile)) {
			subicon = "fav";
			favicon = "fragile";
			copyrgt = c_purple;
		}else if(titledata.contains(amasharing)) {
			subicon = "fav";
			favicon = "amasharing";
			copyrgt = c_pencil;
		}else if(titledata.contains(phl)) {
			subicon = "fav";
			favicon = "phl";
			copyrgt = c_rsk;
		}else if(titledata.contains(kakenuke)) {
			subicon = "fav";
			favicon = "kakenuke";
			copyrgt = c_sgpr;
		}else if(titledata.contains(hatsujo)) {
			subicon = "fav";
			favicon = "hatsujo";
			copyrgt = c_wp;
		}else if(titledata.contains(hamidashi)) {
			subicon = "fav";
			favicon = "hamidashi";
			copyrgt = c_ms;
		}else if(titledata.contains(drapri)) {
			subicon = "fav";
			favicon = "drapri";
			copyrgt = c_wp;
		}else if(titledata.contains(nekotsuku)) {
			subicon = "fav";
			favicon = "nekotsuku";
			copyrgt = c_los;
		}else if(titledata.contains(siscan)) {
			subicon = "fav";
			favicon = "siscan";
			copyrgt = c_onmtp;
		}else if(titledata.contains(piecies) && titledata.contains(somnium)) {
			subicon = "fav";
			favicon = "somnium";
			copyrgt = c_wp;
		}else if(titledata.contains(piecies) && titledata.contains(canary)) {
			subicon = "fav";
			favicon = "canary";
			copyrgt = c_wp;
		}else if(titledata.contains(koikatu_ss)) {
			subicon = "fav";
			favicon = "koikatuss";
			copyrgt = c_illusion;
		}else if(titledata.contains(koikatu) || titledata.contains(koikatu_)) {
			subicon = "fav";
			favicon = "koikatu";
			copyrgt = c_illusion;
		}else if(titledata.contains(dohnadohna)) {
			subicon = "fav";
			favicon = "dohnadohna";
			copyrgt = c_alicesoft;
		}

		System.out.println("[Exec SubIcon]: " + subicon);
		System.out.println("[Exec FavIcon]: " + favicon);
		System.out.println("[Exec Copyright]: " + copyrgt);

		// Discord�ڑ�
		DiscordRPC lib = DiscordRPC.INSTANCE;
		String applicationId = appID.length() != 0 && appIconID.length() != 0 ? appID : originAppID;
		String steamId = "";
		DiscordEventHandlers handlers = new DiscordEventHandlers();
		lib.Discord_Initialize(applicationId, handlers, true, steamId);
		DiscordRichPresence presence = new DiscordRichPresence();
		presence.startTimestamp = System.currentTimeMillis() / 1000; // epoch second
		presence.details = titledata;
		presence.state = cstat;
		presence.largeImageKey = favicon;
		presence.largeImageText = ">>> Game Launcher <<< \n dcon: " + dconver;
		if(subicon != null)
		{
			// presence.largeImageText = titledata + " \n (c)" + copyrgt;
			presence.largeImageText = titledata;
			presence.smallImageKey = subicon;
			presence.smallImageText = ">>> Game Launcher <<< \n dcon: " + dconver;
		}
		lib.Discord_UpdatePresence(presence);
		// in a worker thread
		new Thread(() -> {
			while (!Thread.currentThread().isInterrupted()) {
				lib.Discord_RunCallbacks();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException ignored) {}
			}
		}, "RPC-Callback-Handler").start();
	}

	public static Path getApplicationPath(Class<?> cls) throws URISyntaxException {
		ProtectionDomain pd = cls.getProtectionDomain();
		CodeSource cs = pd.getCodeSource();
		URL location = cs.getLocation();
		URI uri = location.toURI();
		Path path = Paths.get(uri);
		return path;
	}
}

