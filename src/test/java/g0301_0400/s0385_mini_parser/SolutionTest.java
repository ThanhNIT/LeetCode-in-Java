package g0301_0400.s0385_mini_parser;

import g0301_0400.s0341_flatten_nested_list_iterator.NestedInteger;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class SolutionTest {
    @Test
    void deserialize() {
        assertThat(
                new Solution().deserialize("324").getInteger(),
                equalTo(324));
    }

    @Test
    void deserialize2() {
        NestedInteger nestedInteger = new Solution().deserialize("[123,[456,[789]]]");
        int[] result =
                new int[]{nestedInteger.getList().get(0).getInteger(),
                        nestedInteger.getList().get(1).getList().get(0).getInteger(),
                        nestedInteger.getList().get(1).getList().get(1).getList().get(0).getInteger()};
        int[] expected = new int[]{123, 456, 789};
        assertThat(result,
                equalTo(expected));
    }
}
