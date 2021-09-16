package com.sullivankw.NBAWinTotalsPredictor;

import com.sullivankw.CoinMetrics.DateUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

public class DateUtilsTest {

    @Test
    public void testFromLocalDate() {
        LocalDate original = LocalDate.of(2021, 9, 13);
        String converted = DateUtils.fromLocalDate(original);
        Assert.assertEquals("13-09-2021", converted);
    }

    @Test
    public void testFromUnix() {
        long unix = 1631145600000L;
        Date date = DateUtils.fromUnix(unix);
        Assert.assertTrue(date.toString().contains("Sep 08"));
    }
}
