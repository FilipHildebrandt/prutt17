/**
 * Created by Leonard on 2017-05-18.
 */

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class LifeTree extends TreeFrame{


    @Override
    void initTree() {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("Liv.xml");

            NodeList bioList = doc.getElementsByTagName("Biosfär");
            Node rootNode = bioList.item(0);
            String level = rootNode.getNodeName();
            String name = rootNode.getAttributes().getNamedItem("namn").getNodeValue();
            String text = rootNode.getFirstChild().getNodeValue();

            LifeNode ln = new LifeNode(name, level, text);

            root = ln;
            treeModel = new DefaultTreeModel(root);
            tree = new JTree(treeModel);
            buildTree(rootNode);

        } catch (ParserConfigurationException e){
            e.printStackTrace();
        } catch (SAXException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void buildTree(Node rootNode){
        NodeList list = rootNode.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            if (list.item(i).getNodeType() == Node.ELEMENT_NODE) {
                buildTree(list.item(i), root);
            }
        }
    }

    private void buildTree(Node n, DefaultMutableTreeNode parent){
        String level = n.getNodeName();
        String name = n.getAttributes().getNamedItem("namn").getNodeValue();
        String text = n.getFirstChild().getNodeValue();

        LifeNode ln = new LifeNode(name, level, text);

        DefaultMutableTreeNode child = ln;
        parent.add(child);

        for (int i = 0; i < n.getChildNodes().getLength(); i++) {
            if(n.getChildNodes().item(i).getNodeType() == Node.ELEMENT_NODE){
                buildTree(n.getChildNodes().item(i), child);
            }
        }
    }

    void showDetails(TreePath p){
        if (p == null)
            return;
        LifeNode lNode = (LifeNode) p.getLastPathComponent();
        JOptionPane.showMessageDialog(this, getAttributes(lNode));
    }

    String getAttributes(LifeNode node){
        String out = node.getName() + ": " + node.getText();

        if (null != node.getParent()){
            out += "Men allt som är " + node.getName();
        }
        while (null != node.getParent()){
            LifeNode pNode = (LifeNode) node.getParent();
            out += " är " + pNode.getName();
            node = pNode;
        }

        out += ".";
        return out;
    }


    public static void main(String[] args) {
        LifeTree lifeTree = new LifeTree();
    }
}
