package ru.mail.noknod.jetlore.test.core;


import java.time.LocalDateTime;

import ru.mail.noknod.jetlore.test.utils.common.DataOptions;
import ru.mail.noknod.jetlore.test.common.DataOptionsImmutbaleException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;


public class FeedDataTest {
    @Test()
    @DisplayName("Constructing a instance of FeedData")
    public void constructTest() {
        DataOptions options =
                DataOptions()
                .put(_keyOption, _valueOption)
                .put(_anotherKeyOption, _anotherValueOption);

        this.feedData = FeedData(
                _taskUID,
                _urlStr,
                _feedStr,
                _timestamp
                ).mergeOptions(options)
                .setImmutable();
    }

    @Test()
    @DisplayName("Check a value for taskUID")
    public void taskUIDTest() {
        Assertions.assertTrue(_taskUID.equals(this._feed.getTaskUID()));
    }

    @Test()
    @DisplayName("Check a value for urlStr")
    public void urlStrTest() {
        Assertions.assertTrue(_urlStr.equals(this._feed.getUrl()));
    }

    @Test()
    @DisplayName("Check a value for feedStr")
    public void feedStrTest() {
        Assertions.assertTrue(_feedStr.equals(this._feed.getFeed()));
    }

    @Test()
    @DisplayName("Check a value for timestamp")
    public void timestampTest() {
        Assertions.assertTrue(_timestamp.isEqual(this._feed.getTimestamp()));
    }

    @Test()
    @DisplayName("Check a value for options")
    public void taskUIDTest() {
        DataOptions options = this._feed.getOptions();

        Assertions.assertEquals(2, options.size());

        Assertions.assertEquals(_valueOption, options.get(_keyOption));

        Assertions.assertEquals(
                _anotherValueOption, options.get(_anotherKeyOption));

        Assertions.assertNull(options.get("something_weird"));

        Assertions.assertThrows(
                DataOptionsImmutbaleException,
                options.put("something_weird", ""));
    }

    @Test()
    @DisplayName("Throw exception on trying to change immutable feedData")
    public void taskUIDTest() {
        Assertions.assertThrows(
                DataOptionsImmutbaleException,
                this._feed.put("something_weird", ""));
    }

    private static String _taskUID = "Task-1-UID";

    private static String _urlStr = "https://www.facebook.com/yuriy.klyushkin.3";

    private static String _feedStr =
                "Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile";

    private static LocalDateTime _timestamp = LocalDateTime.now();

    private static String _keyOption = "key";

    private static Object _valueOption = "value";

    private static String _anotherKeyOption = "anotherKey";

    private static Object _anotherValueOption = "anotherValue";

    private FeedData _feed = null;
}
