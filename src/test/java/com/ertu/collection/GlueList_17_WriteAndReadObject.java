package com.ertu.collection;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.ertu.collection.GlueList;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GlueList_17_WriteAndReadObject {

    @Test
    public void test_1_write() {

        GlueList<String> glueList = new GlueList<>();
        glueList.add("a");
        glueList.add("b");
        glueList.add("c");


        try {
            FileOutputStream fos = new FileOutputStream("../listText");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(glueList);

            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        assertEquals(3, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void test_2_read() {

        GlueList<String> glueList = new GlueList<>();

        try {
            FileInputStream fis = new FileInputStream("../listText");
            ObjectInputStream ois = new ObjectInputStream(fis);

            glueList = (GlueList<String>) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }

        assertEquals(3, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }
}
