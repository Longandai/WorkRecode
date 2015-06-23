/*    */ package com.neusoft.unieap.core.protection;
/*    */ 
/*    */ import com.neusoft.unieap.platform.protection.LicenseInfo;
/*    */ import com.neusoft.unieap.platform.protection.ProtectionCheck;
/*    */ import com.neusoft.unieap.platform.protection.ProtectionConfig;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import java.util.Properties;
/*    */ import javax.servlet.ServletRequest;
/*    */ import javax.servlet.ServletResponse;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class Protection
/*    */ {
/* 18 */   protected static final Log logger = LogFactory.getLog(Protection.class);
/*    */ 
/*    */   public static synchronized String check(ServletRequest paramServletRequest, ServletResponse paramServletResponse)
/*    */   {
/* 28 */    
/* 36 */     return null;
/*    */   }
/*    */ 
/*    */   public static synchronized boolean check(Boolean paramBoolean)
/*    */   {
/* 45 */     Properties localProperties = new Properties();
/* 46 */     localProperties.put("platform.version", "4.0");
/* 47 */     ProtectionCheck.getInstance().addProperties(localProperties);
/* 48 */     return true;
/*    */   }
/*    */ 
/*    */   public static void startCheckThread()
/*    */   {
/* 55 */     Properties localProperties = new Properties();
/* 56 */     localProperties.put("platform.version", "4.0");
/* 57 */     ProtectionCheck.getInstance().addProperties(localProperties);
/* 58 */     ProtectionCheck.getInstance().startCheckThread();
/*    */   }
/*    */ 
/*    */   public void logLicenseInfo()
/*    */   {
/* 65 */     LicenseInfo localLicenseInfo = ProtectionCheck.getInstance().getLicenseInfo();
/* 66 */     String str1 = localLicenseInfo.getType();
/* 67 */     String str2 = localLicenseInfo.getProjectName();
/* 68 */     String str3 = localLicenseInfo.getProperty("common.customer");
/* 69 */     if (str1.equals("deployment")) {
/* 70 */       if (str3.length() > 0) {
/* 71 */         logger.info("customer name:" + str3);
/*    */       }
/* 73 */       if (str2.length() > 0) {
/* 74 */         logger.info("limit for use:" + str2);
/*    */       }
/* 76 */       logger.info("license type:deployment");
/* 77 */       logger.info("limit for date:unlimited");
/* 78 */     } else if (str1.equals("unlimited")) {
/* 79 */       if (str3.length() > 0) {
/* 80 */         logger.info("customer name:" + str3);
/*    */       }
/* 82 */       if (str2.length() > 0) {
/* 83 */         logger.info("limit for use:" + str2);
/*    */       }
/* 85 */       logger.info("license type:unlimited");
/* 86 */       logger.info("limit for date:unlimited");
/*    */     } else {
/* 88 */       logger.info("license type:development");
/* 89 */       logger.info("limit for date:" + formatDate(localLicenseInfo
/* 90 */         .getIssueDate()) + 
/* 91 */         " to " + 
/* 92 */         formatDate(localLicenseInfo
/* 93 */         .getExpireDate()));
/*    */     }
/*    */   }
/*    */ 
/*    */   private String formatDate(Date paramDate) {
/* 98 */     SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
/* 99 */     return localSimpleDateFormat.format(paramDate);
/*    */   }
/*    */ }

