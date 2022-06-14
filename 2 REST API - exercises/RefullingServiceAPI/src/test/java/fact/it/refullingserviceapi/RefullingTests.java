package fact.it.refullingserviceapi;

import fact.it.refullingserviceapi.model.Refulling;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RefullingTests {

    private Refulling refulling;

    @Test
    void refuelling30litersAnd500km() {
        refulling =
                new Refulling(
                        1,
                        100,
                        600,
                        30
                );
        assertEquals(6,refulling.getFuelConsumption());
    }
    @Test
    void refuelling10litersAnd500km() {
        refulling =
                new Refulling(
                        1,
                        100,
                        600,
                        10
                );
        assertEquals(2,refulling.getFuelConsumption());
    }
    @Test
    void refuelling20litersAnd400km() {
        refulling =
                new Refulling(
                        1,
                        300,
                        700,
                        20
                );
        assertEquals(5,refulling.getFuelConsumption());
    }
    @Test
    void setANewAmountInLitres() {
        refulling =
                new Refulling(
                        1,
                        300,
                        700,
                        20
                );
        refulling.setAmountInLitres(30.6);
        assertEquals(30.6,refulling.getAmountInLitres());
    }
    @Test
    void setANewPreviousMileage() {
        refulling =
                new Refulling(
                        1,
                        300,
                        700,
                        20
                );
        refulling.setPreviousMileage(329);
        assertEquals(329,refulling.getPreviousMileage());
    }
    @Test
    void setANewCurrentMileage() {
        refulling =
                new Refulling(
                        1,
                        300,
                        700,
                        20
                );
        refulling.setCurrentMileage(1010);
        assertEquals(1010,refulling.getCurrentMileage());
    }
    @Test
    void setANewId() {
        refulling =
                new Refulling(
                        1,
                        300,
                        700,
                        20
                );
        refulling.setId(9);
        assertEquals(9,refulling.getId());
    }

}
