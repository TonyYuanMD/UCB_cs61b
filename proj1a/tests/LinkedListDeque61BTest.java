import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

/** Performs some basic linked list tests. */
public class LinkedListDeque61BTest {

    @Test
    public void add_first_from_empty() {
        Deque61B<String> dq = new LinkedListDeque61B<>();
        dq.addFirst("a");
        assertThat(dq.toList()).containsExactly("a").inOrder();
    }

    @Test
    public void add_last_from_empty() {
        Deque61B<String> dq = new LinkedListDeque61B<>();
        dq.addLast("a");
        assertThat(dq.toList()).containsExactly("a").inOrder();
    }

    @Test
    public void add_first_nonempty() {
        Deque61B<String> dq = new LinkedListDeque61B<>();
        dq.addLast("b");
        dq.addFirst("a");
        assertThat(dq.toList()).containsExactly("a", "b").inOrder();
    }

    @Test
    public void add_last_nonempty() {
        Deque61B<String> dq = new LinkedListDeque61B<>();
        dq.addFirst("a");
        dq.addLast("b");
        assertThat(dq.toList()).containsExactly("a", "b").inOrder();
    }

    @Test
    public void add_first_after_remove_to_empty() {
        Deque61B<Integer> dq = new LinkedListDeque61B<>();
        dq.addLast(1);
        dq.removeFirst();
        dq.addFirst(2);
        assertThat(dq.toList()).containsExactly(2).inOrder();
    }

    @Test
    public void add_last_after_remove_to_empty() {
        Deque61B<Integer> dq = new LinkedListDeque61B<>();
        dq.addFirst(1);
        dq.removeLast();
        dq.addLast(2);
        assertThat(dq.toList()).containsExactly(2).inOrder();
    }

    // ----------------- REMOVE TESTS -----------------

    @Test
    public void remove_first() {
        Deque61B<Integer> dq = new LinkedListDeque61B<>();
        dq.addLast(1);
        dq.addLast(2);
        dq.removeFirst();
        assertThat(dq.toList()).containsExactly(2).inOrder();
    }

    @Test
    public void remove_last() {
        Deque61B<Integer> dq = new LinkedListDeque61B<>();
        dq.addLast(1);
        dq.addLast(2);
        dq.removeLast();
        assertThat(dq.toList()).containsExactly(1).inOrder();
    }

    @Test
    public void remove_first_to_empty() {
        Deque61B<Integer> dq = new LinkedListDeque61B<>();
        dq.addLast(1);
        dq.removeFirst();
        assertThat(dq.toList()).isEmpty();
    }

    @Test
    public void remove_last_to_empty() {
        Deque61B<Integer> dq = new LinkedListDeque61B<>();
        dq.addLast(1);
        dq.removeLast();
        assertThat(dq.toList()).isEmpty();
    }

    @Test
    public void remove_first_to_one() {
        Deque61B<Integer> dq = new LinkedListDeque61B<>();
        dq.addLast(1);
        dq.addLast(2);
        dq.removeFirst();
        assertThat(dq.toList()).containsExactly(2).inOrder();
    }

    @Test
    public void remove_last_to_one() {
        Deque61B<Integer> dq = new LinkedListDeque61B<>();
        dq.addLast(1);
        dq.addLast(2);
        dq.removeLast();
        assertThat(dq.toList()).containsExactly(1).inOrder();
    }

    // ----------------- GET TESTS -----------------

    @Test
    public void get_valid() {
        Deque61B<String> dq = new LinkedListDeque61B<>();
        dq.addLast("a");
        dq.addLast("b");
        assertThat(dq.get(1)).isEqualTo("b");
    }

    @Test
    public void get_oob_large() {
        Deque61B<String> dq = new LinkedListDeque61B<>();
        dq.addLast("a");
        assertThat(dq.get(5)).isNull();
    }

    @Test
    public void get_oob_neg() {
        Deque61B<String> dq = new LinkedListDeque61B<>();
        dq.addLast("a");
        assertThat(dq.get(-1)).isNull();
    }

    @Test
    public void get_recursive_valid() {
        Deque61B<String> dq = new LinkedListDeque61B<>();
        dq.addLast("a");
        dq.addLast("b");
        assertThat(dq.getRecursive(1)).isEqualTo("b");
    }

    @Test
    public void get_recursive_oob_large() {
        Deque61B<String> dq = new LinkedListDeque61B<>();
        dq.addLast("a");
        assertThat(dq.getRecursive(5)).isNull();
    }

    @Test
    public void get_recursive_oob_neg() {
        Deque61B<String> dq = new LinkedListDeque61B<>();
        dq.addLast("a");
        assertThat(dq.getRecursive(-1)).isNull();
    }

    // ----------------- SIZE TESTS -----------------

    @Test
    public void size() {
        Deque61B<Integer> dq = new LinkedListDeque61B<>();
        dq.addLast(1);
        dq.addLast(2);
        assertThat(dq.size()).isEqualTo(2);
    }

    @Test
    public void size_after_remove_to_empty() {
        Deque61B<Integer> dq = new LinkedListDeque61B<>();
        dq.addLast(1);
        dq.removeLast();
        assertThat(dq.size()).isEqualTo(0);
    }

    @Test
    public void size_after_remove_from_empty() {
        Deque61B<Integer> dq = new LinkedListDeque61B<>();
        dq.removeFirst();
        assertThat(dq.size()).isEqualTo(0);
    }

    // ----------------- ISEMPTY TESTS -----------------

    @Test
    public void is_empty_true() {
        Deque61B<Integer> dq = new LinkedListDeque61B<>();
        assertThat(dq.isEmpty()).isTrue();
    }

    @Test
    public void is_empty_false() {
        Deque61B<Integer> dq = new LinkedListDeque61B<>();
        dq.addLast(1);
        assertThat(dq.isEmpty()).isFalse();
    }

    // ----------------- TOLIST TESTS -----------------

    @Test
    public void to_list_empty() {
        Deque61B<Integer> dq = new LinkedListDeque61B<>();
        assertThat(dq.toList()).isEmpty();
    }

    @Test
    public void to_list_nonempty() {
        Deque61B<Integer> dq = new LinkedListDeque61B<>();
        dq.addLast(1);
        dq.addLast(2);
        assertThat(dq.toList()).containsExactly(1, 2).inOrder();
    }
}