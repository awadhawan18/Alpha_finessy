package com.example.abhi.alpha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PrivacyPolicy extends AppCompatActivity {

    TextView t;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy__policy);
        setTitle("Privacy Policy");

        t = findViewById(R.id.privacy_text);

        s = "Privacy Policy\n" +
                "We, at 'Finessy' (Owner of Abroad Manager website and its services), are committed to respecting your online privacy and recognize your need for appropriate protection and management of any personally identifiable information (\"Personal Information\") you share with us.\n" +
                "\"Personal Information\" means any information that may be used to identify an individual, including, but not limited to, a first and last name, a home or other physical address and an email address or other contact information, whether at work or at home.\n" +
                "We may change this policy from time to time. Changes to our policy will be updated on our Websites and/or Services only. You should check our policy from time to time to ensure that you are happy with any modifications.\n" +
                "\n" +
                "1. What Information We Collect\n" +
                "We may collect the following information:\n" +
                "•\tName and job title\n" +
                "•\tGender and date of birth\n" +
                "•\tContact information including telephone number and email address\n" +
                "•\tDemographic information such as postcode, preferences and interests\n" +
                "•\tOther information required or relevant to registration for our services.\n" +
                "•\tOther information relevant to customer surveys and/or offers.\n" +
                "\n" +
                "A. AbroadManager User\n" +
                "In order to become an AbroadManager User, you must provide us the following information to create an account: first name, last name, email address and password. Without this minimal amount of information, you cannot create an account. We may request other information from you during the account creation process, (e.g., gender, location, etc.) that we may use to provide better, more customized marketing services such as updates, better ads, and more valuable information. You acknowledge that this information is personal to you, and by creating an account on our website; you allow us and selected third parties, to identify you and to allow to use your information in accordance with our Terms of Use agreement.\n" +
                "\n" +
                "B. Cookies\n" +
                "Some of our Web pages may utilize \"cookies\" and other tracking technologies. A \"cookie\" is a small text file that may be used, for example, to collect information about Web site activity. Some cookies and other technologies may serve to recall Personal Information previously indicated by a Web user. Most browsers allow you to control cookies, including whether or not to accept them and how to remove them.\n" +
                "You may set most browsers to notify you if you receive a cookie, or you may choose to block cookies with your browser, but please note that if you choose to erase or block your cookies, you will need to re-enter your original user ID and password to gain access to certain parts of the Web site and some sections of the site would not work.\n" +
                "Tracking technologies may record information such as Internet domain and host names; Internet protocol (IP) addresses; browser software and operating system types; clickstream patterns; and dates and times that our site is accessed. Our use of cookies and other tracking technologies allows us to improve our Web site and your Web experience. We may also analyze information that for trends and statistics.\n" +
                "\n" +
                "C. Advertising\n" +
                "We may choose to show ads on any of AbroadManager’s web pages at any place.\n" +
                "\n" +
                "We may target ads to Site Users based on general profile information or on non-personally identifiable information inferred from a Site User’s profile (e.g. industry, school, gender, age, nationality, or other relevant information). AbroadManager does not provide personally identifiable information to any third party ad network.\n" +
                "\n" +
                "Third party advertisers may use cookies to track the number of anonymous users responding to their campaigns. We will not have access to or control of cookies placed by third parties.\n" +
                "\n" +
                "You have the ability to accept or decline cookies by modifying your browser preferences. You can accept all cookies, be notified when a cookie is set, or reject all cookies.\n" +
                "\n" +
                "D. Log files, IP Addresses and Information About Your Computer and Mobile Device\n" +
                "Due to the communications standards on the internet, when you visit our Website or Services we automatically receive the URL of the site from which you came and the site to which you are going to when you leave our Websites or Services.\n" +
                "\n" +
                "Additionally, advertisers receive the URL of the page you were on when you click on an ad on our Websites or Services. We may also receive the internet protocol (“IP”) address of your computer, your computer operating system and type of web browser you are using, email patterns, your mobile device and mobile operating system (if you are accessing our Websites or Services using a mobile device), as well as the name of your ISP or your mobile carrier.\n" +
                "\n" +
                "E. Rights to Access, Correct and Eliminate Information About You\n" +
                "You have a right to access, modify, correct and eliminate the data you supplied to us. If you update any of your information, we may keep a copy of the information that you originally provided to us in our archives for uses documented in this policy. You may amend your information by logging onto the Website or Service and accessing your user profile. \n" +
                "\n" +
                "F. Data Retention\n" +
                "We will retain your information for so long as your account is active or as needed to provide you Websites or Services. We will retain and use your information as necessary to comply with our legal obligations, resolve disputes, and enforce this Agreement.\n" +
                "\n" +
                "\n" +
                "2. What We Do With The Information We Gather\n" +
                "By providing information to AbroadManager for the purposes of becoming a Site User, creating your AbroadManager User account or adding any additional details to your AbroadManager User profile, you are expressly and voluntarily accepting the terms and conditions of this Privacy Policy and AbroadManager’s Terms of Use Agreement that allow AbroadManager to process information about you.\n" +
                "\n" +
                "Supplying information to AbroadManager, including any information deemed “sensitive” by applicable law, is entirely voluntary on your part. You have the right to withdraw your consent to AbroadManager’s collection and processing of your information at any time, in accordance with the terms of this Privacy Policy and the Terms of Use Agreement, by changing your Settings, or by closing your account, but please note that your withdrawal of consent will not be retroactive.\n" +
                "\n" +
                "We require this information to understand your needs and provide you with a better service, and in particular for the following reasons:\n" +
                "•\tAbroadManager Communications\n" +
                "•\tInternal record keeping \n" +
                "•\tTo enhance our products and services\n" +
                "\n" +
                "We may periodically send promotional email about new products, special offers or other information which we think you may find interesting using the email address which you have provided\n" +
                "From time to time, we may also use your information to contact you for market research purposes.\n" +
                "We may contact you by email, phone, text or mail.\n" +
                "We may use the information to customize the Websites or Services according to demographic interests.\n" +
                "\n" +
                "\n" +
                "3. Links to Other Websites\n" +
                "Our Websites or Services may contain links to other websites of interest. However, once you have used these links to leave our site, you should note that we do not have any control over that other website. Therefore, we cannot be responsible for the protection and privacy of any information which you provide whilst visiting such sites and such sites are not governed by this privacy statement. You should exercise caution and look at the privacy statement applicable to the website in question.\n" +
                "\n" +
                "\n" +
                "4. Controlling your personal information\n" +
                "If you believe that any information we are holding on you is incorrect or incomplete, please write an email to us as soon as possible, at the addresses mentioned in our contact us page. We will promptly correct any information found to be incorrect.\n" +
                "\n" +
                "\n" +
                "5. Security\n" +
                "To protect any data you store on our servers, AbroadManager regularly audits its system for possible vulnerabilities and attacks. However, since the internet is not a 100% secure environment, we cannot ensure or warrant the security of any information you transmit to AbroadManager. There is no guarantee that information may not be accessed, disclosed, altered, or destroyed by breach of any of our physical, technical, or managerial safeguards.\n" +
                "\n" +
                "\n" +
                "6. Your Obligations\n" +
                "As a Site User, you have certain obligations to other Site Users. Some of these obligations are imposed by applicable law and regulations, and others have become commonplace in user-friendly communities of like-minded members such as AbroadManager:\n" +
                "•\tYou must, at all times, abide by the terms and conditions of the then-current Privacy Policy and Terms of Use agreement. This includes respecting all intellectual property rights that may belong to third parties (such as trademarks or photographs).\n" +
                "•\tYou must not download or otherwise disseminate any information that may be deemed to be injurious, violent, offensive, racist or xenophobic, or which may otherwise violate the purpose and spirit of AbroadManager and its community.\n" +
                "•\tYou must not provide to AbroadManager and/or other Site Users information that you believe might be injurious or detrimental to your person or to your professional or social status.\n" +
                "•\tYou must keep your password confidential and not share it with others\n" +
                "•\tAny violation of these guidelines may lead to the restriction, suspension or termination of your account at the sole discretion of AbroadManager.\n" +
                "\n";

        t.setText(s);
    }
}
