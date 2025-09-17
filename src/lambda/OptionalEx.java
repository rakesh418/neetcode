package lambda;

import java.util.Optional;

public class OptionalEx {
    public static void main(String[] args) {
        String[] nums = new String[10];
        nums[5]="rakesh";
        Optional<String> opt = Optional.of("Rakesh");
        Optional<String> opt1 = Optional.ofNullable(null);
        Optional<String> opt2 = Optional.ofNullable("mumu");
        System.out.println(opt.get());
        System.out.println(opt1.orElse("hohohooh"));
        System.out.println(opt2.orElse("hohohooh"));
    }
}
