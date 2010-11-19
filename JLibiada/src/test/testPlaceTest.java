package test;

import junit.framework.TestCase;
import libiada.EventTheory.Dimension;
import libiada.EventTheory.Place;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: ������
 * Date: 18.11.2010
 * Time: 0:27:58
 * To change this template use File | Settings | File Templates.
 */
public class testPlaceTest extends TestCase {
    @Test
    //��������� ����������� ���� �������� null ������������
    public void testConstructorNull()
    {
        try
        {
            new Place(null);
            fail();
        }
        catch (Exception e)
        {
            ;// TODO: "����������� � ���������� C# � �������� ���� AssertionException"
        }
    }

    @Test
    //��������� ����������� ���� �������� ������ ������������
    public void testConstructorFreeSpace()
    {
        try
        {
            new Place(new ArrayList<Dimension>());
            fail();
        }
        catch (Exception e)
        {
             ;// TODO: "����������� � ���������� C# � �������� ���� AssertionException"
        }
    }

    @Test
    //��������� ����������� ���� �������� ����������� ���������� ���� � ���� ��������� > 1 ����
    public void testConstructorBrokenSpace()
    {
        ArrayList<Dimension> Ar = new ArrayList<Dimension>();
        Dimension Ds = new Dimension(0, 10);
        Ar.add(new Dimension(-50, -48));
        Ar.add(Ds);
        Ar.add(Ds);
        Ar.add(new Dimension(-2, 10));
        try
        {
            new Place(Ar);
        }
        catch (Exception e)
        {
            fail();
        }
    }

    @Test
    //��������� ����������� � �������� ������� ��������� > �������
    public void testConstructorFirstDimensionLess()
    {
        ArrayList<Dimension> Ar = new ArrayList<Dimension>();
        Ar.add(new Dimension(-50, -48));
        Ar.add(new Dimension(-2, 10));
        Place pl = new Place(Ar);
        assertTrue((Ar.get(0)).EqualsAsDimension(pl.getDimension().get(0)));
        assertTrue((Ar.get(1)).EqualsAsDimension(pl.getDimension().get(1)));
    }

    @Test
    //��������� ����������� � �������� ������� ��������� < �������
    public void testConstructorSecondDimensionLess()
    {
        ArrayList<Dimension> Ar = new ArrayList<Dimension>();
        Ar.add(new Dimension(-50, 150));
        Ar.add(new Dimension(-2, 10));
        Place pl = new Place(Ar);
        assertTrue((Ar.get(0)).EqualsAsDimension(pl.getDimension().get(0)));
        assertTrue((Ar.get(1)).EqualsAsDimension(pl.getDimension().get(1)));
    }

    @Test
    //��������� ����������� � �������� ������� ��������� ������� �������
    public void testConstructorDimensionsEquals()
    {
        ArrayList<Dimension> Ar = new ArrayList<Dimension>();
        Ar.add(new Dimension(0, 150));
        Ar.add(new Dimension(0, 150));
        Place pl = new Place(Ar);
        assertTrue((Ar.get(0)).EqualsAsDimension(pl.getDimension().get(0)));
        assertTrue((Ar.get(1)).EqualsAsDimension(pl.getDimension().get(1)));
    }

    @Test
    //��������� ���� �������� �� ������������(���� �� �������� �� ���������)
    public void testConstructorNotAllAreDimension()
    {
        ArrayList Ar = new ArrayList();
        Ar.add(new Dimension(-50, 100));
        Ar.add(new Object());
        Ar.add(new Dimension(-2, 10));
        Place Pl = null;
        try
        {
           Pl = new Place(Ar);
           fail();
        }
        catch (Exception e)
        {
              //
            // TODO: "����������� � ���������� C# � �������� ���� AssertionException"
//            if (e.GetType() == typeof (AssertionException))
//            {
//                Assert.Fail();
//            }
            if (Pl == null) {
                return;
            }
            assertEquals(Pl.getDimension().size(), Array.getLength(Pl.getValues()));
        }
    }

    @Test
    //��������� �������� ����� ������ ������� ��� �������� Place ���������
    public void testtestChangeSpaceAfterCreateSpace()
    {
        ArrayList<Dimension> Ar = new ArrayList<Dimension>();
        Ar.add(new Dimension(0, 150));
        Place Pl = new Place(Ar);
        Ar.add(new Dimension(0, 150));
        Ar.add(new Dimension(0, 150));
        Ar.add(new Dimension(0, 150));
        assertEquals(1, Array.getLength(Pl.getDimension()));
        assertEquals(1, Array.getLength(Pl.getValues()));
    }

    @Test
    //��������� �������� ����� �������� ��������� ������� ��������� �������� ������ ������ ��� �����������
     public void testSetValueIndexGreateThanMax()
     {
        ArrayList<Dimension> Ar = new ArrayList<Dimension>();
        Ar.add(new Dimension(0, 10));
        Place Pl = new Place(Ar);
        try
        {
            Pl.setValue(10, 3);
            fail();
        }
        catch (Exception e)
        {
            // TODO: "����������� � ���������� C# � �������� ���� AssertionException"
//            if (e.GetType() == typeof (AssertionFailError))
//            {
//                fail();
//            }
        }
     }

     @Test
    //��������� �������� ����� �������� ��������� ������� ��������� �������� ������ ������ 0
    public void testSetValueIndexLessThanZero()
    {
        ArrayList<Dimension> Ar = new ArrayList<Dimension>();
        Ar.add(new Dimension(0, 10));
        Place Pl = new Place(Ar);
        try
        {
            Pl.setValue(10, -3);
            fail();
        }
        catch (Exception e)
        {
            // TODO: "����������� � ���������� C# � �������� ���� AssertionException"
//            if (e.GetType() == typeof (AssertionException))
//            {
//                fail();
//            }
        }
    }

    @Test
    //��������� �������� ����� �������� ��������� ������� ������ ����������� ������� �� ������� ���������� ���������
    public void testSetValueLessThanMin()
    {
        ArrayList Ar = new ArrayList();
        Ar.add(new Dimension(0, 10));
        Place Pl = new Place(Ar);
        try
        {
           Pl.setValue(-10, 0);
           fail();
        }
        catch (Exception e)
        {
           // TODO: "����������� � ���������� C# � �������� ���� AssertionException"
//           if (e.GetType() == typeof (AssertionException))
//           {
//               fail();
//           }
        }
    }

    @Test
    // ��������� �������� ����� �������� ��������� ������� ������ ������������ ������� �� ������� ���������� ���������
    public void testSetValueGreateThanMax()
    {
        ArrayList<Dimension> Ar = new ArrayList<Dimension>();
        Ar.add(new Dimension(0, 10));
        Place Pl = new Place(Ar);
        try
        {
            Pl.setValue(100, 0);
            fail();
        }
        catch (Exception e)
        {
           // TODO: "����������� � ���������� C# � �������� ���� AssertionException"
//           if (e.GetType() == typeof (AssertionException))
//           {
//               fail();
//           }
        }
    }

    // ��������� �������� ����� �������� ��������� ������� ������ ������������ ������� �� ������� ���������� ���������
    @Test
    public void testSetValueEqualsMax()
    {
        ArrayList<Dimension> Ar = new ArrayList<Dimension>();
        Ar.add(new Dimension(0, 10));
        Place Pl = new Place(Ar);
        try
        {
            Pl.setValue(10, 0);
        }
        catch (Exception e)
        {
            fail();
        }
    }

    // ��������� �������� ����� �������� ��������� ������� ������ ����������� ������� �� ������� ���������� ���������
    @Test
    public void testSetValueEqualsMin()
    {
        ArrayList<Dimension> Ar = new ArrayList<Dimension>();
        Ar.add(new Dimension(0, 10));
        Place Pl = new Place(Ar);
        try
        {
            Pl.setValue(0, 0);
        }
        catch (Exception e)
        {
            fail();
        }
    }

    // ��������� ��������� � ������� ������
    @Test
    public void TestSetValueInWorkMode()
    {
        ArrayList<Dimension> Ar = new ArrayList<Dimension>();
        Ar.add(new Dimension(0, 10));
        Place Pl = new Place(Ar);
        try
        {
            Pl.setValue(5, 0);
        }
        catch (Exception e)
        {
            fail();
        }
    }
}
