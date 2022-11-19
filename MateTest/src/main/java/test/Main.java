package test;

import java.text.DecimalFormat;
import java.time.ZoneId;
import java.util.*;
import java.util.Objects;
import java.util.function.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(toArrayOfDigits(-234)));
/*        System.out.println(isArrayPretty(new int[]{2, 10, 9, 3}));
        Set<Integer> setInts1 = new HashSet<>();
        Set<Integer> setInts2 = new HashSet<>();
        setInts1.add(1);
        setInts1.add(0);
        setInts1.add(2);
        setInts2.add(1);
        setInts2.add(2);
        setInts2.add(3);
        System.out.println(symmetricDifference(setInts1, setInts2));*/

        System.out.println(calculateTotalTime(new int[]{10, 2, 3, 3}, 2));
        System.out.println(isValidParentheses("no paren(thes"));

        final String[] COLORS = {"red", "green", "blue", "yellow", "pink",
                "black", "white"};
        Supplier<String> getRandomColor = new Supplier<String>() {
            @Override
            public String get() {
                Random random = new Random();
                return COLORS[random.nextInt(7)];
            }
        };
        /*for (int i= 0; i < 100; i++) {
            String actualColor = getRandomColor.get();
            System.out.println(actualColor);
        }*/
        Random random = new Random();
        int index = random.nextInt(7);
        Function<Integer, String> randomColor = new Function<Integer, String>() {
            @Override
            public String apply(Integer index) {
                return COLORS[index];
            }
        };
        System.out.println(randomColor.apply(index));

        BiFunction<Integer, Integer, Integer> engines = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a - b;
            }
        };
        System.out.println(engines.apply(200, 300));

        Predicate<Engine> engineTypePredicate = new Predicate<Engine>() {
            @Override
            public boolean test(Engine engineType) {
                return Objects.equals(engineType.getEngineType(), Engine.EngineType.ELECTRIC);
            }
        };

        Function<Integer, AutoType> findAutoType = new Function<Integer, AutoType>() {
            @Override
            public AutoType apply(Integer integer) {
                return integer < 1500 ? AutoType.CAR : AutoType.TRUCK;
            }
        };
        AutoType actual = findAutoType.apply(1204);
        System.out.println(actual);

        System.out.println(getOddNumsSum(List.of(1, 2, 3, 4, 5, 6, 8)));
        System.out.println(calculateOccurrences(List.of("qe", "ty", "we", "yu", "ty", "ty"), "ty"));
        System.out.println(getFirstElement(List.of("qe", "ty", "we", "yu", "ty", "ty")));
        System.out.println(getThreeSmallestNumbers(new int[]{90, 2, 9, 4, 54, 6, 8}));
        System.out.println(findElement(List.of("qe", "ty", "we", "yu", "ty", "ty"), "ty"));
        System.out.println(getVisitorsPerYear(List.of("John Stevenson:2020", "Andrew Ferguson:2020", "Andrew Ferguson:2012", "Andrew Ferguson:2013"), 2020));
        String aaa = "John Stevenson:2020";
        System.out.println(aaa.chars().filter(c -> Character.isAlphabetic(c)).distinct().count());
        String[] ccc = aaa.split(" ");
        System.out.println(Arrays.stream(ccc).distinct().collect(Collectors.joining(" ")));
        IntStream bbb = aaa.chars();
        System.out.println(bbb.map(c -> c + 2)
                .mapToObj(Character::toString)
                .collect(Collectors.joining()));

        String uu = Integer.toBinaryString(566);

        int[] inputNumbers = {9, 25, 16, 11, 10, 50, 89, 20};
        System.out.println(Arrays.stream(inputNumbers)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .filter(n -> n % 5 == 0)
                .collect(Collectors.toList()));

        List<String> words = List.of("g", "gregory", "abcdgy", "victory", "dance", "republic", "future", "compilation", "convention");
        System.out.println(words.stream()
                .filter(w -> Character.isAlphabetic(w.charAt(w.length() - 1)))
                .collect(Collectors.groupingBy(w -> w.charAt(w.length() - 1),
                        Collectors.mapping(String::new, Collectors.toList()))));

        System.out.println(getPrimorialOfNumber(5));
        System.out.println(IntStream.range(0, 6).sum());
        System.out.println(Stream.of(9, 11, 55, 6, 12, 3)
                .filter(i -> i > 10)
                .mapToInt(Integer::intValue)
                .sum()
        );

        System.out.println(getAvg(new int[]{2, 4}));

        TimeZone timeZone = TimeZone.getDefault();
        ZoneId zoneId = timeZone.toZoneId();
        System.out.println(zoneId);

        List<Integer> integerList = List.of(11, 22, 3, 44, 5, 61, 8);
        integerList.stream()
                .filter(n -> n > 10)
                .mapToInt(i -> i)
                .sum();

        System.out.println(getNextBiggerNumber(1283331765));

        System.out.println(Stream.of("a", "b", "c")
                .flatMapToInt(String::chars)
                .map(c -> (c + 1) - 97)
                .sum());

        System.out.println(String.valueOf((char) 103));
        System.out.println(addIntegers(6, 4));

        int[] nums = new int[]{2, 4, 2, 5, 7, 3, 5, 2, 5, 6, 5, 9, 45, 5};
        System.out.println("pizda " + Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()))
                .entrySet()
                .stream()
                .max((o1, o2) -> (int) (o1.getValue() - o2.getValue())).get().getKey());

        Node list1 = new Node(1, new Node(2, new Node(3)));
        Node list2 = new Node(2, new Node(4, new Node(6)));

        System.out.println(addTwoNumbers(list1, list2).data + " " + addTwoNumbers(list1, list2).next);

        System.out.println(detectAutomorphic(76));
        int number = 39;
        int[] integerArr = Stream.iterate(1, n -> n + 2)
                .limit(number % 2 == 0 ? number / 2 : number / 2 + 1)
                .mapToInt(n -> n)
                .toArray();
        System.out.println(Arrays.toString(integerArr));

        System.out.println(convertToCamelCase("books-already-read"));
        System.out.println(convertToCamelCase("Long_function_Name"));

        System.out.println(calculateMoves("test", "rest"));

        String wordss = "this string is pretty long ling and i hope you will manage to light find the highest scoring word";
        String[] wordssArr = wordss.split(" ");
        Object[] collectInt = Arrays.stream(wordssArr)
                .map(String::chars)
//                .map(IntStream::sum)
                .toArray();
        System.out.println(Arrays.toString(collectInt));
        int[] counts = new int[wordssArr.length];
        for (int i = 0; i < wordssArr.length; i++) {
            for (int j = 0; j < wordssArr[i].length(); j++) {
                counts[i] += wordssArr[i].charAt(j) - 96;
            }
        }
        System.out.println(Arrays.toString(counts));
        Map<Integer, String> resulting = new TreeMap<>();
        for (int i = counts.length - 1; i >= 0; i--) {
            resulting.put(counts[i], wordssArr[i]);
        }
        System.out.println(resulting.get(resulting.keySet().stream().max(Comparator.naturalOrder()).get()));

        System.out.println(getSumConsecutives(List.of(1, 2, 2)));


        Map<String, Integer> stringIntegerMap = Arrays.stream(wordss.split(" "))
                .distinct()
                .collect(Collectors.toMap(Function.identity(),
                        c -> c.chars().map(x -> x - 96).sum()));
//        Set<String> strings = stringIntegerMap.keySet();
        System.out.println(stringIntegerMap.entrySet().stream().min((o1, o2) -> o2.getValue() - o1.getValue()).get()
                .getKey());


/*        Connection connection = ConnectionUtil.getConnection();
        Statement getAllFormatsStatement = null;
        try {
            getAllFormatsStatement = connection.createStatement();
            ResultSet resultSet = getAllFormatsStatement.executeQuery(
                    "SELECT * FROM library_db.literary_formats");
            while (resultSet.next()) {
                String format = resultSet.getString("format");
                long id = resultSet.getObject("id", Long.class);
//                LiteraryFormat literaryFormat = new LiteraryFormat();
                System.out.println(format + " " + id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/

        System.out.println(isValidCardNumber("4111111111111111"));

        System.out.println(getBackwardsPrimes(1, 13));

        System.out.println(removeLetter("abcdefghijklmnopqrstuvwxyz", 10));

        List<List<String>> collection = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"));
        System.out.println(collection.stream().flatMap(Collection::stream)
                .collect(Collectors.toSet()));

        List<Employee> employees = asList(new Employee("a", 10, "male", "123"),
                new Employee("b", 12, "female", "234"),
                new Employee("c", 3, "female", "2346"));
        System.out.println(employees.stream().max(Comparator.comparingInt(employee -> employee.getAge())));
        System.out.println(employees.stream()
                .collect(Collectors.toMap(p -> p.getAge() >= 12, p -> new ArrayList<>(Arrays.asList(p)), (a, b) -> {
                    a.addAll(b);
                    return a;
                })));
        System.out.println(employees.stream()
                .collect(Collectors.toMap(Employee::getSex, p -> new ArrayList<>(asList(p)), (a, b) -> {
                    a.addAll(b);
                    return a;
                })));

        List<Integer> numbersInts = asList(1, 2, 3, 4, 5);
        System.out.println(numbersInts.stream().reduce(Integer::sum).get());
        String evenOdds = numbersInts.stream().map(n -> n % 2 == 0 ? "e" + n : "o" + n)
                .collect(Collectors.joining(","));
        System.out.println(evenOdds);
        System.out.println(numbersInts.stream()
                .mapToDouble(n -> n)
                .average().getAsDouble());

        System.out.println(Arrays.stream(wordss.split(" "))
                .map(s -> s.toUpperCase())
                .filter(w -> String.valueOf(w.charAt(0)).equals("L"))
                .filter(w -> w.length() == 4)
                .toList());

        if (Character.isAlphabetic(wordss.charAt(0))) System.out.println("is ok");

        System.out.println(Arrays.stream(wordss.split(" "))
                .filter(Objects::nonNull)
                .map(c -> c.charAt(0))
                .map(c -> c.toString().toLowerCase())
                .map(c -> c.charAt(0))
                .sorted()
                .collect(Collectors.toList()));

        System.out.println(getTriangular(4));

        System.out.println(convertString("Mate ACADEmy"));

        System.out.println(isValid("){[]}()"));

        System.out.println(getMaxRotations(38458215));

        System.out.println(isValidMessage("3hey5hello2hi5"));

        System.out.println(Arrays.toString(separateWheatFromChaff(new long[]{7, -8, 1, -2})));

        System.out.println(isPrime("aseaseasee"));

        System.out.println(isTidy(125648));

        System.out.println(findUnique(new double[]{2, 2, 2, 3, 2}));

        System.out.println(toSimplePigLatin("The sentence of five words"));

        System.out.println(mumble("sEfTg"));

        System.out.println(getNthPerson
        (new String[]{"Batman", "Superman", "Spiderman", "Wonderwoman", "Antman"}, 23));

        System.out.println(modifyData("Program title: Nail\nAuthor: Schwarz\nCorporation: Asus\nPhone: +1-503-555-0072\nDate: Tues March 10, 2004\nVersion: 0.2\nLevel: Release", "Circular", "1.7"));

        System.out.println(Integer.parseInt("1111", 2));

        System.out.println(wordss.replaceAll("i", "[i]"));

        System.out.println(orderWeights("500 600 1003 41 800000 "));

        System.out.println(Arrays.deepToString(multiplySquareMatrices(
                new int[][]{{9, 7}, {0, 1}}, new int[][]{{1, 1}, {4, 12}})));

        System.out.println(extractRange(new int[]{-3, -2, -1, 2, 10, 15, 16, 18, 19, 20}));

        System.out.println(findCubicNumbers("40702"));

        System.out.println(formatDuration(94878183));

        System.out.println(Arrays.toString(getSnail(
                new int[][]{{2, 9, 10, 12}, {3, -3, 14, 52}, {19, 18, 4, 7}, {10, 0, 8, 41}})));

        System.out.println(isEndsWith("abc", "bc"));

        System.out.println(countIPBetween("50.0.0.0", "50.1.1.1"));

        System.out.println(sellTickets(new int[]{25, 25, 50, 50, 25, 50, 25, 100, 25, 50}));

        System.out.println(Arrays.toString(sortArray(new String[]{"3", "1", "2"})));
        System.out.println(Arrays.toString(sortArray(new Integer[]{3, 1, 2})));
        System.out.println(Arrays.toString(sortArray(new int[]{3, 1, 2})));
        System.out.println(Arrays.toString(sortArray(new double[]{3.0, 1, 2})));
        System.out.println(Arrays.toString(sortArray(new float[]{3, 1, 2})));

        System.out.println(calculateRotations("coffee", "eecoff"));

        System.out.println(numberOfDividers(30));

        System.out.println(isAscOrder(new int[]{1,6,10}));

        System.out.println(createPassphrase("BORN IN 2015!", 1));

        System.out.println(findPairs(new int[]{1, 4, 4, 4, 1}));

        System.out.println(getAveragePercentage("466960, 069060, 494940, 060069, 060090, 640009, 496464, 606900, 004000, 944096"));
    }


    public static double getAveragePercentage(String string) {
        String[] splitString = string.split(", ");
        double combinations = String.valueOf(splitString[0]).length() * splitString.length * (splitString.length - 1) / 2D;
        int count = 0;
        for (int i = 0; i < splitString.length - 1; i++) {
            for (int k = i + 1; k < splitString.length; k++) {
                StringBuilder first = new StringBuilder(splitString[i]);
                StringBuilder second = new StringBuilder(splitString[k]);
                 do {
                    if (first.charAt(0) == second.charAt(0)) {
                        count++;
                    }
                    first.deleteCharAt(0);
                    second.deleteCharAt(0);
                } while (first.length() > 0);
            }
        }
        System.out.println(count + " " + combinations);
        return count / combinations * 100;
    }

    public static int findPairs(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        List<Integer> numbersList = new ArrayList<>();
        int count = 0;
        for (int n : nums) {
            if (numbersList.contains(n)) {
                numbersList.remove(Integer.valueOf(n));
                count++;
            } else {
                numbersList.add(n);
            }
        }
        return count;
    }


    public static String createPassphrase(String phrase, int shift) {
        StringBuilder sb = new StringBuilder();
        int[] temp = phrase.toLowerCase().chars().toArray();
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] >= 97 && temp[i] <= 122) {
            int c = temp[i] + shift;
                if (c > 122) {
                    c -= 26;
                }
                String letter = String.valueOf((char) c);
                if (i % 2 == 0) {
                    sb.append(letter.toUpperCase());
                } else {
                    sb.append(letter.toLowerCase());
                }
            } else if (temp[i] >= 48 && temp[i] <= 57) {
                sb.append(57 - temp[i]);
            } else {
                sb.append((char) temp[i]);
            }
        }
        sb.reverse();
        return sb.toString();
    }

    private static boolean isAscOrder(int[] ints) {
        int[] temp = Arrays.copyOf(ints, ints.length);
        Arrays.sort(temp);
        return Arrays.equals(temp, ints);
    }

    private static int numberOfDividers(int i) {
        return (int) IntStream.range(1, i + 1)
                .filter(n -> i % n == 0)
                .count();

    }


    public static int calculateRotations(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return -1;
        }
        StringBuilder sb = new StringBuilder(string1);
        int count = 0;
        for (int i = string2.length() - 1; i > 0; i--) {
            char c = sb.charAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            sb.insert(0, c);
            count++;
            if (sb.toString().equals(string2)) {
                return count;
            }
        }
        return -1;
    }

    public static int[] sortArray(int[] names) {
        return Arrays.stream(names).sorted().toArray();
    }

    public static double[] sortArray(double[] names) {
        return Arrays.stream(names).sorted().toArray();
    }

    public static Integer[] sortArray(Integer[] names) {
    Arrays.sort(names);
    return names;
    }

    public static float[] sortArray(float[] names) {
        Arrays.sort(names);
        return names;
    }

    public static String[] sortArray(String[] names) {
        /*List<String> strings = Arrays.stream(names)
                .sorted()
                .map(s -> (String) s)
                .collect(Collectors.toList());
        return strings.toArray(new String[0]);*/
        Arrays.sort(names);
        return names;
    }

    public static String sellTickets(int[] peopleInLine) {
        int count25 = 0;
        int count50 = 0;
        for (int person : peopleInLine) {
            if (person == 25) {
                count25++;
                continue;
            }
            if (person == 50) {
                if (count25 > 0) {
                    count25--;
                    count50++;
                    continue;
                } else {
                    return "NO";
                }
            }
            if (count50 > 0 && count25 > 0) {
                count50--;
                count25--;
            } else if (count25 > 2) {
                count25 -= 2;
            } else {
                return "NO";
            }
        }
        return "YES";
    }


    public static long countIPBetween(String start, String end) {
        DecimalFormat df = new DecimalFormat("00000000");
        StringBuilder startBinary = new StringBuilder();
        StringBuilder endBinary = new StringBuilder();
        String[] startArray = start.split("\\.");
        String[] endArray = end.split("\\.");
        for (String s : startArray) {
            startBinary.append(df.format(Integer.valueOf(Integer.toBinaryString(Integer.parseInt(s)))));
        }
        for (String s : endArray) {
            endBinary.append(df.format(Integer.valueOf(Integer.toBinaryString(Integer.parseInt(s)))));
        }
        return Long.valueOf(endBinary.toString(), 2) - Long.valueOf(startBinary.toString(), 2);
    }

    public static List<Character> getUniqueCharacters(String sourceString) {

        return sourceString.chars()
                .distinct()
                .mapToObj(i -> (char) i)
                .collect(Collectors.toList());
    }

    public static boolean isEndsWith(String string, String ending) {
        return string.endsWith(ending);
    }

    public static int[] getSnail(int[][] nums) {
        List<Integer> resList = new LinkedList<>();
        int[] result = new int[(nums.length * nums.length)];
        int count = 0;
        int[][] clock = Arrays.copyOf(nums, nums[0].length);
        while (clock.length > 0) {
            for (int i = 0; i < clock[0].length; i++) {
                resList.add(clock[0][i]);
                result[count] = clock[0][i];
                count++;
            }
            clock = turnArrayClockwise(clock);
        }

        return resList.stream().mapToInt(i -> i).toArray();
    }

    private static int[][] turnArrayClockwise(int[][] temp) {
        int[][] clock = new int[temp[0].length][temp.length - 1];
        for (int i = 0; i < clock.length; i++) {
            for (int j = 0; j < clock[0].length; j++) {
                clock[i][j] = temp[j + 1][temp[0].length - 1 - i];
            }
        }
        return clock;
    }


    public static String formatDuration(int seconds) {
        if (seconds == 0) {
            return "now";
        }
        Queue<String> res = new ArrayDeque<>();
        int year = seconds / (365 * 24 * 3600);
        if (year > 0) {
            res.add(year == 1 ? "1 year" : year + " years");
        }

        seconds = seconds % (365 * 24 * 3600);
        int day = seconds / (24 * 3600);
        if (day > 0) {
            res.add(day == 1 ? "1 day" : day + " days");
        }

        seconds = seconds % (24 * 3600);
        int hour = seconds / 3600;
        if (hour > 0) {
            res.add(hour == 1 ? "1 hour" : hour + " hours");
        }

        seconds %= 3600;
        int minute = seconds / 60 ;
        if (minute > 0) {
            res.add(minute == 1 ? "1 minute" : minute + " minutes");
        }

        seconds %= 60;
        int sec = seconds;
        if (sec > 0) {
            res.add(sec == 1 ? "1 second" : sec + " seconds");
        }

        int count = res.size();
        if (count == 1) {
            return res.peek();
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            if (i == count - 1) {
                result.deleteCharAt(result.length() - 1)
                        .deleteCharAt(result.length() - 1)
                        .append(" and ").append(res.remove());
            } else {
                result.append(res.remove()).append(", ");
            }
        }

        return result.toString();
    }


    public static String findCubicNumbers(String string) {
        StringBuilder sb = new StringBuilder(string);
        List<StringBuilder> sbList = new ArrayList<>();
        while (sb.length() != 0) {
            if (!Character.isDigit(sb.charAt(0))) {
                sb.deleteCharAt(0);
                continue;
            } else {
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < 3; i++) {
                    temp.append(sb.charAt(0));
                    sb.deleteCharAt(0);
                    if (sb.length() != 0 && !Character.isDigit(sb.charAt(0))) {
                        sb.deleteCharAt(0);
                        break;
                    }
                    if (sb.length() == 0) {
                        break;
                    }
                }
                sbList.add(temp);
            }
        }
        StringBuilder res = new StringBuilder();
        int sum = 0;
        for (StringBuilder element : sbList) {
            int number = Integer.parseInt(String.valueOf(element));
            double cubicSum = String.valueOf(element).chars()
                    .mapToDouble(c -> Math.pow(c - 48, 3))
                    .sum();
            if (cubicSum == number) {
                res.append(number).append(" ");
                sum += number;
            }
        }
        return res.length() == 0? "Unlucky" : res.append(sum).append(" Lucky").toString();
    }


    public static String extractRange(int[] nums) {
        StringBuilder sb = new StringBuilder();
        int rangeCounter = 0;
        int rangeStart = 0;
        int rangeEnd = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1] - 1) {
                if (rangeCounter == 0) {
                    rangeStart = nums[i];
                }
                rangeEnd = nums[i + 1];
                rangeCounter++;
            } else {
                if (rangeCounter == 0) {
                    sb.append(nums[i]).append(",");
                    continue;
                } else if (rangeCounter == 1){
                    sb.append(rangeStart).append(",").append(rangeEnd).append(",");
                } else {
                    sb.append(rangeStart).append("-").append(rangeEnd).append(",");
                }
                rangeCounter = 0;
            }
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static int[][] multiplySquareMatrices(int[][] a, int[][] b) {
        int[][] c = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j <a.length; j++) {
                c[i][j] = findCell(a, b, i, j);
            }
        }
        return c;
    }

    private static int findCell(int[][] a, int[][] b, int i, int j) {
        int sum = 0;
        int temp = 0;
        for (int k = 0; k < a.length; k++) {
            temp = a[i][k] * b[k][j];
            sum += temp;
        }
        return sum;
    }

    public static String orderWeights(String weights) {
        String[] numbers = weights.trim().split("\\s+");
        System.out.println(Arrays.toString(numbers[0].chars().map(c -> c - 48).toArray()));
        Comparator<String> comparator = (o1, o2) -> {
            int i1 = o1.chars().map(c -> c - 48).sum();
            int i2 = o2.chars().map(c -> c - 48).sum();
            if (i1 > i2) {
                return 1;
            } else if (i1 < i2) {
                return -1;
            }
            return o1.compareTo(o2);
        };
        System.out.println(Arrays.toString(numbers));
        return Arrays.stream(numbers)
                .sorted(comparator)
                .collect(Collectors.joining(" "));

    }

    public static String modifyData(String data, String program, String version) {
        String[] dataArray = data.split("\n");
        Pattern pattern = Pattern.compile("^\\+1-\\d{3}-\\d{3}-\\d{4}");
        Pattern vers = Pattern.compile("^\\d+\\.\\d+");
        String phone = dataArray[3].substring(7);
        String versionVal = dataArray[5].substring(9);
        System.out.println(versionVal);
        Matcher matcher = pattern.matcher(phone);
        Matcher versionValid = vers.matcher(versionVal);
        if (!matcher.matches() || !versionValid.matches()) {
            return "ERROR: VERSION or PHONE";
        }
        dataArray[0] = "Program: " + program;
        dataArray[1] = "Author: g964";
        dataArray[3] = "Phone: +1-503-555-0090";
        dataArray[4] = "Date: 2019-01-01";
        dataArray[5] = versionVal.equals("2.0") ? dataArray[5] : "Version: " + version;
        return dataArray[0] + "\n"
                + dataArray[1] + "\n"
                + dataArray[3] + "\n"
                + dataArray[4] + "\n"
                + dataArray[5] + "\n";
    }


    public static String getNthPerson(String[] names, int n) {
        Deque<String> deque = new ArrayDeque<>(List.of(names));
        int m = 1;
        int k = 0;
        for (int i = 1; i < n; i = i + m) {
            String firstInQueue = deque.removeFirst();
            deque.offerLast(firstInQueue);
//            deque.offerLast(firstInQueue);
            k++;
            m *= k % names.length == 0 ? 2 : 1;
        }
        return deque.getFirst();
    }

    public static String mumble(String string) {
        if (string.equals("")) {
            return string;
        }
        StringBuilder res = new StringBuilder(String.valueOf(string.charAt(0)).toUpperCase());
        for (int i = 1; i < string.length(); i++) {
            res.append("-");
            res.append(String.valueOf(string.charAt(i)).toUpperCase());
            for (int j = 0; j < i; j++) {
                res.append(String.valueOf(string.charAt(i)).toLowerCase());
            }
        }
        return res.toString();
    }


    public static String toSimplePigLatin(String string) {
        return Arrays.stream(string.split(" "))
                .map(s -> {
                    if (Character.isAlphabetic(s.charAt(0))) {
                        char temp = s.charAt(0);
                        return s.substring(1) + temp + "ay";
                    }
                    return s;
                })
                .collect(Collectors.joining(" "));
    }

    public static double findUnique(double nums[]) {
        Arrays.sort(nums);
        return nums[0] == nums[1] ? nums[nums.length - 1] : nums[0];
    }

    public static boolean isTidy(int number) {
        String string = "" + number;
        String sorted = string.chars()
                .sorted()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        return sorted.equals(string);
    }

    public static long[] separateWheatFromChaff(long[] nums) {
        long[] n = Arrays.copyOf(nums, nums.length);
        int start = 0;
        int end = n.length - 1;
        while (start <= end) {
            if (n[start] > 0) {
                if (n[end] < 0) {
                    long temp = n[start];
                    n[start] = n[end];
                    n[end] = temp;
                }
                end--;
            } else {
                start++;
            }
        }
        return n;
    }


    public static boolean isPrime(String string) {
        if (string.length() <= 3) {
            return true;
        }
        StringBuilder subStr = new StringBuilder(string.substring(0, 1));
        for (int i = 1; i < string.length() / 2; i++) {
            String temp = string.replaceAll(String.valueOf(subStr), "");
            if (temp.length() == 0) {
                return false;
            }
            subStr.append(string.charAt(i));
        }
        return true;
    }

    public static boolean isValidMessage(String message) {
        if (message.equals("") || message.equals("0")) {
            return true;
        }
        if (Character.isAlphabetic(message.charAt(0))) {
            return false;
        }
        StringBuilder temp = new StringBuilder(message);
        StringBuilder temp1 = new StringBuilder();
        while (temp.length() != 0) {
            temp1.append(temp.charAt(0));
            if (Character.isAlphabetic(temp1.charAt(0))) {
                return false;
            }
            temp.deleteCharAt(0);
            if (temp.length() == 0) {
                return false;
            }
            if (!Character.isAlphabetic(temp.charAt(0))) {
                continue;
            }
            int num = Integer.parseInt(String.valueOf(temp1));
            temp1 = new StringBuilder();
            if (temp.length() < num) {
                return false;
            }
            for (int i = 0; i < num; i++) {
                if (!Character.isAlphabetic(temp.charAt(0))) {
                    return false;
                }
                temp.deleteCharAt(0);
            }
        }
        return true;
    }


    public static long getMaxRotations(long number) {
        List<Long> res = new ArrayList<>();
        res.add(number);
        StringBuilder temp = new StringBuilder(String.valueOf(number));
        StringBuilder temp2;
        StringBuilder temp3;
        for (int i = 0; i < String.valueOf(number).length(); i++) {
            temp2 = new StringBuilder(temp.substring(0, i));
            temp.delete(0, i);
            temp3 = new StringBuilder(temp.substring(0, 1));
            temp.delete(0, 1);
            temp.append(temp3);
            temp2.append(temp);
            temp = temp2;
            res.add(Long.parseLong(String.valueOf(temp2)));
        }
        Collections.sort(res);
        Collections.reverse(res);
        return res.get(0);
    }


    public static boolean isValid(String string) {
        StringBuilder builder = new StringBuilder(string);
        while (!builder.isEmpty()) {
            int index1 = builder.indexOf("{}");
            if (index1 != -1) {
                builder.replace(index1, index1 + 2, "");
            }
            int index2 = builder.indexOf("[]");
            if (index2 != -1) {
                builder.replace(index2, index2 + 2, "");
            }
            int index3 = builder.indexOf("()");
            if (index3 != -1) {
                builder.replace(index3, index3 + 2, "");
            }
            if (index1 == -1 && index2 == -1 && index3 == -1) {
                return false;
            }
        }
        return true;
    }

    public static String convertString(String string) {
        int occurrencesLower = occurrences("[a-z]", string);
        int occurrencesUpper = occurrences("[A-Z]", string);
        return occurrencesLower >= occurrencesUpper ? string.toLowerCase() : string.toUpperCase();
    }

    public static int occurrences(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int matches = 0;
        while (matcher.find()) {
            matches++;
        }
        return matches;
    }


    public static int getTriangular(int n) {
        if (n <= 0) {
            return 0;
        }
//        n += n - 1;
        return n + getTriangular(n - 1);
    }

    public static String removeLetter(String string, int n) {
        StringBuilder temp = new StringBuilder(string);
        char deletingChar = 97;
        while (n > 0) {
            if (deletingChar > 122 || temp.isEmpty()) {
                break;
            }
            int indexOf = temp.indexOf(String.valueOf(deletingChar));
            if (indexOf == -1) {
                deletingChar++;
                continue;
            }
            temp.deleteCharAt(indexOf);
            n--;
        }
        return temp.toString();
    }

    public static String getBackwardsPrimes(long start, long end) {
        List<Long> longs = LongStream.range(start, end)
                .filter(n -> isPrimeNumber((int) n))
                .boxed().toList();
        System.out.println(longs);
        StringBuilder res = new StringBuilder();
        for (Long number : longs) {
            StringBuilder numString = new StringBuilder(String.valueOf(number));
            numString.reverse();
            if (numString.length() > 1 && isPrimeNumber(Integer.parseInt(String.valueOf(numString)))) {
                res.append(number).append(" ");
            }
        }
        return res.toString().trim();
    }

    private static boolean isPrimeNumber(int number) {
        for (int i = 2; i < Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidCardNumber(String cardNumber) {
        long num = Long.parseLong(cardNumber);
        int count = 1;
        int res = 0;
        while (num > 0) {
            if (count % 2 == 1) {
                res += num % 10;
                System.out.println(res);
            } else {
                res += (num % 10) * 2 > 9 ? (num % 10) * 2 - 9 : (num % 10) * 2;
                System.out.println(res);
            }
            count++;
            num /= 10;
        }
        System.out.println(res);
        return res % 10 == 0;
    }


    public static boolean isValidCardNumber1(String cardNumber) {
        int sum1 = 0;
        int sum2 = 0;
        int res;
        if (cardNumber.length() % 2 == 0) {
            sum1 = getSum1(cardNumber);
            sum2 = getSum2(cardNumber);
        } else {
            sum2 = getSum1(cardNumber);
            sum1 = getSum2(cardNumber);
        }
        res = sum1 + sum2;
        System.out.println(sum1 + " " + sum2 + " " + res);
        if (res % 10 == 0) {
            return true;
        }
        return false;
    }

    private static int getSum2(String cardNumber) {
        int sum2;
        sum2 = cardNumber.chars()
                .filter(c -> c % 2 == 1)
                .map(c -> {
                    int sum = c * 2;
                    if (sum > 9) {
                        sum -= 9;
                    }
                    return sum;
                })
                .sum();
        return sum2;
    }

    private static int getSum1(String cardNumber) {
        int sum1;
        sum1 = cardNumber.chars()
                .filter(c -> c % 2 == 0)
                .map(c -> c - 46)
                .sum();
        System.out.println(sum1);
        return sum1;
    }


    public static List<Integer> getSumConsecutives(List<Integer> list) {
        int temp = list.get(0);
        List<Integer> list1 = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            if (Objects.equals(list.get(i), list.get(i - 1))) {
                temp += list.get(i);
            } else {
                list1.add(temp);
                temp = list.get(i);
            }
        }
        list1.add(temp);
        return list1;
    }

    public static int calculateMoves(String word1, String word2) {
        StringBuilder first = new StringBuilder(word1);
        StringBuilder second = new StringBuilder(word2);
        boolean isEqual = false;
        int count = 0;
        for (int i = 0; i < word1.length() + word2.length(); i++) {
            if (first.length() >= second.length()) {
                isEqual = shrink(first, second);
            } else {
                isEqual = shrink(second, first);
            }
            count++;
            if (isEqual) {
                break;
            }
        }
        if (isEqual) {
            return count;
        }
        return 0;
    }

    private static boolean shrink(StringBuilder first, StringBuilder second) {
        first.deleteCharAt(0);
        return Objects.equals(first.toString(), second.toString());
    }

    public static String convertToCamelCase(String string) {
        String[] arr = string.split("-|_");
        System.out.println(Arrays.toString(arr));
        String res = Arrays.stream(arr)
                .map(a -> a.substring(0, 1).toUpperCase() + a.substring(1))
                .collect(Collectors.joining());

        String result = Character.isLowerCase(string.charAt(0)) ? res.substring(0, 1).toLowerCase()
                + res.substring(1) : res;
        System.out.println(result);
        return result;
    }

    public static String detectAutomorphic(int number) {
        int square = (int) Math.pow(number, 2);
        String find = String.valueOf(square);
        String stringNumber = String.valueOf(number);
        System.out.println(find.substring(find.length() - stringNumber.length(), find.length()));
        if (find.substring(find.length() - stringNumber.length(), find.length())
                .equals(stringNumber)) {
            return "Automorphic";
        }
        return "Not!!";
    }

    public static Node addTwoNumbers(Node list1, Node list2) {
        int res;
        res = getNumber(list1) + getNumber(list2);
        System.out.println(res);
        StringBuilder temp = new StringBuilder(String.valueOf(res));
        Node head = new Node(Integer.parseInt(String.valueOf(temp.charAt(0))));
        temp.deleteCharAt(0);
        return getResNode(head, temp);
    }

    private static Node getResNode(Node head, StringBuilder temp) {
        Node node;
        if (temp.isEmpty()) {
            return head;
        }
        node = new Node(Integer.parseInt(String.valueOf(temp.charAt(0))), head);
        head = node;
        temp.deleteCharAt(0);
        System.out.println(head.data);
        return getResNode(head, temp);
    }

    private static int getNumber(Node list) {
        StringBuilder temp = new StringBuilder();
        while (list.next != null) {
            temp.append(list.data);
            System.out.println(temp);
            list = list.next;
        }
        temp.append(list.data);
        temp.reverse();
        return Integer.parseInt(temp.toString());
    }

    public static int addIntegers(int a, int b) {
        int count = a & b;
        int result = a ^ b;
        while (count != 0) {
            int anotherCount = count << 1;
            count = result & anotherCount;
            result ^= anotherCount;
        }
        return result;
        // write code here
    }

    public static int getNextBiggerNumber(int n) {
        char[] number = String.valueOf(n).toCharArray();
        for (int i = number.length - 2; i >= 0; i--) {
            for (int j = number.length - 1; j > i; j--) {
                if (number[i] < number[j]) {
                    char tmp = number[i];
                    number[i] = number[j];
                    number[j] = tmp;
                    Arrays.sort(number, i + 1, number.length);
                    return Integer.parseInt(String.valueOf(number));
                }
            }
        }
        return -1;
    }

    public static double getAvg(int[] array) {
        return Arrays.stream(array)
                .average()
                .orElseThrow();
    }


    public static String getPrimorialOfNumber(int number) {
        if (number == 1) {
            return "2";
        }
        int multi = 2;
        int primorial = 2;
        for (int i = 0; i < number - 1; i++) {
            do {
                multi++;
            } while (!isPrime(multi));
            primorial *= multi;
            System.out.println(multi + " " + primorial);
        }
        return String.valueOf(primorial);
    }

    public static boolean isPrime(int n) {
        boolean isPrime = true;
        int sqrt = (int) Math.sqrt(n) + 2;
        for (int i = 2; i < sqrt; i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        System.out.println(n + " " + isPrime);
        return isPrime;
    }

    public static Long getVisitorsPerYear(List<String> records, int year) {
        return records
                .stream()
                .filter(s -> s.substring(s.length() - 4).equals(String.valueOf(year)))
                .distinct()
                .count();
    }

    public static String findElement(List<String> elements, String element) {
        return elements.stream()
                .filter(s -> s.equals(element))
                .findFirst()
                .orElseThrow();
    }

    public static Integer getOddNumsSum(List<Integer> numbers) {

        return numbers.stream()
                .mapToInt(Integer::intValue)
                .filter((n -> n % 2 == 1))
                .sum();
    }

    public static List<Integer> getThreeSmallestNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .sorted()
                .limit(3)
                .boxed()
                .collect(Collectors.toList());
    }

    public static Long calculateOccurrences(List<String> elements, String element) {
        return elements.stream().filter(e -> e.equals(element)).count();
    }

    public static Optional<String> getFirstElement(List<String> elements) {
        return elements.stream().findFirst();
    }

    public enum AutoType {
        CAR,
        TRUCK
    }

    public static boolean isValidParentheses(String string) {
        System.out.println(string);
        if (string.length() == 0) {
            return true;
        }
        if (!string.contains("(") && !string.contains(")")) {
            System.out.println("bred");
            return true;
        }
        int openers = string.length() - string.replaceAll("\\(", "").length();
        int closers = string.length() - string.replaceAll("\\)", "").length();
        System.out.println((string.lastIndexOf(')') > string.lastIndexOf('(')));
        return (openers == closers)
                && (string.lastIndexOf(')') > string.lastIndexOf('('));
    }

    public static int calculateTotalTime(int[] customers, int checkout) {
        int[] checkouts = new int[checkout];
        if (customers.length <= checkout) {
            Arrays.sort(customers);
            return customers[checkout - 1];
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int customer :
                customers) {
            queue.add(customer);
        }
        for (int i = 0; i < checkout; i++) {
            checkouts[i] = queue.poll();
        }
        Arrays.sort(checkouts);
        while (!queue.isEmpty()) {
            int oneCheckout = queue.poll();
            int oneTime = oneCheckout + checkouts[0];
            checkouts[0] = oneTime;
            Arrays.sort(checkouts);
        }
        return checkouts[checkout - 1];
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> setInts1 = new HashSet<>(set1);
        Set<T> setInts2 = new HashSet<>(set2);
        Set<T> res = new HashSet<>();
        setInts1.removeAll(set2);
        setInts2.removeAll(set1);
        res.addAll(setInts1);
        res.addAll(setInts2);
        return res;
    }

    /*public static int[] toArrayOfDigits(int n) {
        n = Math.abs(n);
        String digits = String.valueOf(n);
        int[] result = new int[digits.length()];
        for (int i = digits.length() - 1; i >= 0; i--) {
            result[digits.length() - (i + 1)] = Integer.parseInt(String.valueOf(digits.charAt(i)));
        }
        return result;
    }*/

    public static boolean isArrayPretty(int[] array) {
        if (array.length == 0) {
            return false;
        }
        boolean isPretty = true;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j) {
                    continue;
                }
                int minus = array[j] - 1;
                int plus = array[j] + 1;
                if (array[i] == minus || array[i] == plus) {
                    isPretty = true;
                    break;
                }
                isPretty = false;
            }
            if (!isPretty) {
                break;
            }
        }
        return isPretty;
    }
}
