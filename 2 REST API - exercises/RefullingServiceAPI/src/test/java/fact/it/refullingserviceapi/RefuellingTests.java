package fact.it.refullingserviceapi;

import fact.it.refullingserviceapi.model.Refuelling;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RefuellingTests {

    private Refuelling refuelling;

    @Test
    void refuelling30litersAnd500km() {
        refuelling =
                new Refuelling(
                        1,
                        100,
                        600,
                        30
                );
        assertEquals(6, refuelling.getFuelConsumption());
    }
    @Test
    void refuelling10litersAnd500km() {
        refuelling =
                new Refuelling(
                        1,
                        100,
                        600,
                        10
                );
        assertEquals(2, refuelling.getFuelConsumption());
    }
    @Test
    void refuelling20litersAnd400km() {
        refuelling =
                new Refuelling(
                        1,
                        300,
                        700,
                        20
                );
        assertEquals(5, refuelling.getFuelConsumption());
    }
    @Test
    void setANewAmountInLitres() {
        refuelling =
                new Refuelling(
                        1,
                        300,
                        700,
                        20
                );
        refuelling.setAmountInLitres(30.6);
        assertEquals(30.6, refuelling.getAmountInLitres());
    }
    @Test
    void setANewPreviousMileage() {
        refuelling =
                new Refuelling(
                        1,
                        300,
                        700,
                        20
                );
        refuelling.setPreviousMileage(329);
        assertEquals(329, refuelling.getPreviousMileage());
    }
    @Test
    void setANewCurrentMileage() {
        refuelling =
                new Refuelling(
                        1,
                        300,
                        700,
                        20
                );
        refuelling.setCurrentMileage(1010);
        assertEquals(1010, refuelling.getCurrentMileage());
    }
    @Test
    void setANewId() {
        refuelling =
                new Refuelling(
                        1,
                        300,
                        700,
                        20
                );
        refuelling.setId(9);
        assertEquals(9, refuelling.getId());
    }

}
