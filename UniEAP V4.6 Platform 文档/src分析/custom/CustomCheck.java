/*    */ package com.neusoft.unieap.core.protection.custom;
/*    */ 
/*    */ import com.jp.protection.pub.License;
/*    */ import com.jp.protection.pub.LicenseHost;
/*    */ import com.neusoft.unieap.core.protection.Encipher;
/*    */ import com.neusoft.unieap.core.protection.ProtectionConfig;
/*    */ import com.neusoft.unieap.core.protection.ProtectionSupport;
/*    */ import java.util.Date;
/*    */ 
/*    */ public final class CustomCheck
/*    */ {
/* 12 */   private static CustomCheck instance = new CustomCheck();
/*    */ 
/* 14 */   private ProtectionSupport ps = new ProtectionSupport();
/*    */ 
/* 16 */   private long checkInterval = 10000000L;
/*    */ 
/*    */   public static CustomCheck getInstance()
/*    */   {
/* 22 */     return instance;
/*    */   }
/*    */ 
/*    */   public long getCheckInterval() {
/* 26 */     return this.checkInterval;
/*    */   }
/*    */ 
/*    */   public void setCheckInterval(long paramLong) {
/* 30 */     this.checkInterval = paramLong;
/*    */   }
/*    */ 
/*    */   public synchronized boolean check(boolean paramBoolean) {
/*    */ 
/* 44 */      if (this.ps.checkLicense(paramBoolean)) {
	/* 35 */       String str = getProperty("platform.version", "0");
	/* 36 */       if ((str != null) && ("4.0".equals(str))) {
	/* 37 */         return true;
	/*    */       }
	/* 39 */       ProtectionConfig.errMsg = 
	/* 40 */         Encipher.decodePasswd(ProtectionConfig.err6);
	/* 41 */       return false;
	/*    */     }
	/*    */ 
	/* 44 */     return true;
/*    */   }
/*    */ 
/*    */   public String getProperty(String paramString1, String paramString2) {
/* 48 */     if (this.ps.getLicenseHost().getLicense() != null)
/* 49 */       return this.ps.getLicenseHost().getLicense().getProperty(paramString1, 
/* 50 */         paramString2);
/* 51 */     return "";
/*    */   }
/*    */ 
/*    */   public boolean checkEqualString(String paramString1, String paramString2) {
/* 55 */     if (!isCommerical())
/* 56 */       return true;
/* 57 */     String str = getProperty(paramString1, paramString2);
/* 58 */     if (str.equals(paramString2)) {
/* 59 */       return true;
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */ 
/*    */   public boolean checkEqualInt(String paramString, int paramInt)
/*    */   {
/* 66 */     if (!isCommerical())
/* 67 */       return true;
/* 68 */     String str = getProperty(paramString, String.valueOf(paramInt));
/* 69 */     return paramInt == Integer.parseInt(str);
/*    */   }
/*    */ 
/*    */   public boolean checkLessInt(String paramString, int paramInt) {
/* 73 */     if (!isCommerical())
/* 74 */       return true;
/* 75 */     String str = getProperty(paramString, String.valueOf(paramInt));
/* 76 */     return paramInt > Integer.parseInt(str);
/*    */   }
/*    */ 
/*    */   private boolean isCommerical() {
/* 80 */     return false;
/*    */   }
/*    */ 
/*    */   public Date getLicenseExpireDate() {
/* 84 */     return new Date(9999, 12, 31);
/*    */   }
/*    */ }

