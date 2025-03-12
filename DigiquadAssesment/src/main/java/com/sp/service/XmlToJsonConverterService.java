package com.sp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

@Service
public class XmlToJsonConverterService {

    public String convertXmlToJson(MultipartFile file) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file.getInputStream());
        doc.getDocumentElement().normalize();

        Map<String, Object> dataMap = new HashMap<>();
        parseXmlNode(doc.getDocumentElement(), dataMap);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonOutput = objectMapper.writeValueAsString(dataMap);

        File outputJson = new File("output.json");
        try (FileWriter writer = new FileWriter(outputJson)) {
            writer.write(jsonOutput);
        }
        return outputJson.getAbsolutePath();
    }

    private void parseXmlNode(Node node, Map<String, Object> dataMap) {
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node child = nodeList.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                dataMap.put(child.getNodeName(), child.getTextContent().trim());
            }
        }
    }
}
