/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.manufacturer;

import org.me.models.Product;
import org.me.models.PurchaseOrders;
import org.me.models.PurchaseOrder;
import org.me.models.Products;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import org.me.helpers.ReadProductXML;

/**
 *
 * @author Felicia
 */
public class Driver {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            
            // CREATE PRODUCTS
            Product tvProduct = new Product();
            tvProduct.setManufacturerName("ManufacturerA");
            tvProduct.setProductType("TV" );
            tvProduct.setUnitPrice(250.0f);

            Product dvdPlayerProduct = new Product();
            dvdPlayerProduct.setManufacturerName("ManufacturerB");
            dvdPlayerProduct.setProductType("DVD Player");
            dvdPlayerProduct.setUnitPrice(50.0f);

            Product videoCameraProduct = new Product();
            videoCameraProduct.setManufacturerName("ManufacturerC");
            videoCameraProduct.setProductType("Video Camera");
            videoCameraProduct.setUnitPrice(100.0f);

            Products products = new Products();        
            List productsList = new ArrayList();
            productsList.add(tvProduct);
            productsList.add(dvdPlayerProduct);
            productsList.add(videoCameraProduct);

            products.setProducts(productsList);
            
            // MARSHAL PRODUCTS
            JAXBContext productJC = JAXBContext.newInstance( Product.class, Products.class );
            Marshaller productJM = productJC.createMarshaller();

            /* set this flag to true to format the output */
            productJM.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            /* marshaling of java objects in xml (output to file and standard output) */
            productJM.marshal( products, new File( "products.xml" ) );
            productJM.marshal( products, System.out );
            
            

            // UNMARSHAL PRODUCTS
            Products ps = (Products)productJC.createUnmarshaller().unmarshal(new File("products.xml"));
            List<Product> list = ps.getProducts();
            list.get(0).setManufacturerName("OMFGDFGM");
            System.out.println(list.get(0));

            Marshaller m = productJC.createMarshaller();
            m.marshal(ps,  System.out);
            
            // CREATE ORDERS
            
            PurchaseOrder po = new PurchaseOrder();
            po.setCustomerRef("lol");
            po.setOrderNum("wat");
            po.setProduct(tvProduct);
            po.setQuantity(1);
            po.setUnitPrice(250.0f);
            po.setIsPaid(false);
            
            PurchaseOrders pos = new PurchaseOrders();
            List poList = new ArrayList();
            poList.add(po);
            pos.setPurchaseOrders(poList);
            
            
            // MARSHAL ORDERS
            JAXBContext orderJC = JAXBContext.newInstance( Product.class, Products.class, PurchaseOrder.class, PurchaseOrders.class );
            Marshaller orderJM = orderJC.createMarshaller();

            /* set this flag to true to format the output */
            orderJM.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            /* marshaling of java objects in xml (output to file and standard output) */
            orderJM.marshal( pos, new File( "purchaseOrders.xml" ) );
            orderJM.marshal( pos, System.out );
            
            // unmarshal orders
            System.out.println("*****************************");
            PurchaseOrders purchaseOrders = (PurchaseOrders)orderJC.createUnmarshaller().unmarshal(new File("purchaseOrders.xml" ));
            List<PurchaseOrder> purchaseOrderList  = purchaseOrders.getPurchaseOrders();
            
            Marshaller m2 = orderJC.createMarshaller();
            m2.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
            m2.marshal(purchaseOrders, new File( "purchaseOrders.xml" ));
            m2.marshal(purchaseOrders,  System.out);
            System.out.println("*****************************");
            
            
            
        } catch (Exception e) {
            System.err.println("Could not bind Product POJO to XML file.");
            e.printStackTrace();
        }
    }
    
}
