/* package com.onegateafrica.controller;

import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.api.SessionFactory;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.commons.PropertyIds;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.data.ContentStream;
import org.apache.chemistry.opencmis.commons.enums.BindingType;
import org.apache.chemistry.opencmis.commons.enums.VersioningState;
import org.apache.chemistry.opencmis.commons.impl.dataobjects.ContentStreamImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping */ /*("/al")
public class AlfrescoController {
    @RequestMapping(value="/Alfresco-docs", method = RequestMethod.GET)
    public String createDocument() {
        SessionFactory factory = SessionFactoryImpl.newInstance();
        Map<String, String> parameter = new HashMap<String, String>();
        parameter.put(SessionParameter.USER, "admin");
        parameter.put(SessionParameter.PASSWORD, "admin");
        parameter.put(SessionParameter.ATOMPUB_URL, "http://127.0.0.1:8081/alfresco/api/-default-/public/cmis/versions/1.0/atom");
        parameter.put(SessionParameter.BINDING_TYPE, BindingType.ATOMPUB.value());


        Session session = factory.getRepositories(parameter).get(0).createSession();
        Folder root = session.getRootFolder();

        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(PropertyIds.OBJECT_TYPE_ID, "cmis:folder");
        properties.put(PropertyIds.NAME, "MyFirstFolder");
        Folder oneFolder = root.createFolder(properties);

        Map<String, Object> properties2 = new HashMap<String, Object>();
        properties2.put(PropertyIds.OBJECT_TYPE_ID, "cmis:document");
        properties2.put(PropertyIds.NAME, "MyFirstDocument");

        byte[] content = "hi this is onegateAfrica".getBytes();
        InputStream stream = new ByteArrayInputStream(content);
        ContentStream contentStream = new ContentStreamImpl
                ("MyFirstDocument", BigInteger.valueOf(content.length), "text/plain", stream);


        Document doc = oneFolder.createDocument(properties2, contentStream, VersioningState.MAJOR);
        return "document has been created";}

    @RequestMapping(value="/Alfresco-down", method = RequestMethod.GET)
    public String  downloadDocument()
    {   SessionFactory factory = SessionFactoryImpl.newInstance();
        Map<String, String> parameter = new HashMap<String, String>();
        //user credentials
        parameter.put(SessionParameter.USER,"admin");
        parameter.put(SessionParameter.PASSWORD,"admin");

        //connection settings
        parameter.put(SessionParameter.ATOMPUB_URL,"http://127.0.0.1:8081/alfresco/api/-default-/public/cmis/versions/1.0/atom");
        parameter.put(SessionParameter.BINDING_TYPE, BindingType.ATOMPUB.value());

        //Repository
        parameter.put(SessionParameter.REPOSITORY_ID,"f4cd1fa8-d95a-452c-b559-99468a12afd9");

        //create a session

        Session session = factory.getRepositories(parameter).get(0).createSession();

        Folder root = session.getRootFolder();

        String path = "/myFirstFolder/MyFirstDocument";
        Document doc = (Document) session.getObjectByPath(path);
        try {
            ContentStream cs = doc.getContentStream(null);
            BufferedInputStream in = new BufferedInputStream(cs.getStream());
            File yourFile = new File("C:\\Users\\asus\\Desktop\\APP\\document.txt");
            yourFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(yourFile);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            byte[] buf =new byte[1024];
            int n=0;
            while ((n=in.read(buf)) > 0) {AuthentificationController
                bos.write(buf,0,n);}
            bos.close();
            fos.close();
            in.close();
        }catch(Exception ex){throw new RuntimeException(ex.getLocalizedMessage());}
        return "document5 has been dowloaded" ;
    }

} */
