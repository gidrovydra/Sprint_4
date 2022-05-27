import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckAccountParametrizedTest {

    public String name;
    public boolean expected;

    public CheckAccountParametrizedTest(String name,boolean expected ) {
        this.name = name;
         this.expected = expected;
    }

    @Parameterized.Parameters (name ="{index}: check (name: \"{0}\", result: {1})")
    public static Object[][] checkName() {
        return new Object[][] {
                {"Тимати Шаламе", true},
                {null, false},
                {"",false}, //пустое имя
                {"АБ", false}, // 2 символа + (при этом без пробела)
                {"А Б", true}, // 3 символа
                {"Аа Б", true}, // 4 символа
                {"Восемнадцать симво", true}, //18 символов
                {"Девятнадцать символ", true}, //19 символов
                {"Двадцать символовтут", false }, //20 символов
                {"Тим ати Шаламе", false}, //два пробела
                {"Тимати  Шаламе", false}, //два пробела в середине
                {" ТиматиШаламе", false}, // пробел в начале
                {"ТиматиШаламе ", false}, //пробел в конце
                {"ТиматиШаламе", false}, //без пробела
                {"777 888", true}, //цифры
                {"Timotie Shalame", true}, //латиница
                {"!@#%^%# (*&)(_)!", true} //символы
                
        };
    }

    @Test
    public void checkNameAtRequirements() {
        boolean actual = new Account(name).checkNameToEmboss();
        assertEquals(expected, actual);
    }
}
