import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import net.didion.jwnl.JWNL;
import net.didion.jwnl.JWNLException;
import net.didion.jwnl.data.Word;
import net.didion.jwnl.dictionary.Dictionary;


public class NaturalLanguage {
	public static String[] stopWords = { "a", "as", "able", "about", "above", "according", "accordingly", "across",
			"actually", "after", "afterwards", "again", "against", "aint", "all", "allow", "allows", "almost", "alone",
			"along", "already", "also", "although", "always", "am", "among", "amongst", "an", "and", "another", "any",
			"anybody", "anyhow", "anyone", "anything", "anyway", "anyways", "anywhere", "apart", "appear", "appreciate",
			"appropriate", "are", "arent", "around", "as", "aside", "ask", "asking", "associated", "at", "available",
			"away", "awfully", "be", "became", "because", "become", "becomes", "becoming", "been", "before",
			"beforehand", "behind", "being", "believe", "below", "beside", "besides", "best", "better", "between",
			"beyond", "both", "brief", "but", "by", "cmon", "cs", "came", "can", "cant", "cannot", "cant", "cause",
			"causes", "certain", "certainly", "changes", "clearly", "co", "com", "come", "comes", "concerning",
			"consequently", "consider", "considering", "contain", "containing", "contains", "corresponding", "could",
			"couldnt", "course", "currently", "definitely", "described", "despite", "did", "didnt", "different", "do",
			"does", "doesnt", "doing", "dont", "done", "down", "downwards", "during", "each", "edu", "eg", "eight",
			"either", "else", "elsewhere", "enough", "entirely", "especially", "et", "etc", "even", "ever", "every",
			"everybody", "everyone", "everything", "everywhere", "ex", "exactly", "example", "except", "far", "few",
			"ff", "fifth", "first", "five", "followed", "following", "follows", "for", "former", "formerly", "forth",
			"four", "from", "further", "furthermore", "get", "gets", "getting", "given", "gives", "go", "goes", "going",
			"gone", "got", "gotten", "greetings", "had", "hadnt", "happens", "hardly", "has", "hasnt", "have", "havent",
			"having", "he", "hes", "hello", "help", "hence", "her", "here", "heres", "hereafter", "hereby", "herein",
			"hereupon", "hers", "herself", "hi", "him", "himself", "his", "hither", "hopefully", "how", "howbeit",
			"however", "i", "id", "ill", "im", "ive", "ie", "if", "ignored", "immediate", "in", "inasmuch", "inc",
			"indeed", "indicate", "indicated", "indicates", "inner", "insofar", "instead", "into", "inward", "is",
			"isnt", "it", "itd", "itll", "its", "its", "itself", "just", "keep", "keeps", "kept", "know", "knows",
			"known", "last", "lately", "later", "latter", "latterly", "least", "less", "lest", "let", "lets", "like",
			"liked", "likely", "little", "look", "looking", "looks", "ltd", "mainly", "many", "may", "maybe", "me",
			"mean", "meanwhile", "merely", "might", "more", "moreover", "most", "mostly", "much", "must", "my",
			"myself", "name", "namely", "nd", "near", "nearly", "necessary", "need", "needs", "neither", "never",
			"nevertheless", "new", "next", "nine", "no", "nobody", "non", "none", "noone", "nor", "normally", "not",
			"nothing", "novel", "now", "nowhere", "obviously", "of", "off", "often", "oh", "ok", "okay", "old", "on",
			"once", "one", "ones", "only", "onto", "or", "other", "others", "otherwise", "ought", "our", "ours",
			"ourselves", "out", "outside", "over", "overall", "own", "particular", "particularly", "per", "perhaps",
			"placed", "please", "plus", "possible", "presumably", "probably", "provides", "que", "quite", "qv",
			"rather", "rd", "re", "really", "reasonably", "regarding", "regardless", "regards", "relatively",
			"respectively", "right", "said", "same", "saw", "say", "saying", "says", "second", "secondly", "see",
			"seeing", "seem", "seemed", "seeming", "seems", "seen", "self", "selves", "sensible", "sent", "serious",
			"seriously", "seven", "several", "shall", "she", "should", "shouldnt", "since", "six", "so", "some",
			"somebody", "somehow", "someone", "something", "sometime", "sometimes", "somewhat", "somewhere", "soon",
			"sorry", "specified", "specify", "specifying", "still", "sub", "such", "sup", "sure", "ts", "take", "taken",
			"tell", "tends", "th", "than", "thank", "thanks", "thanx", "that", "thats", "thats", "the", "their",
			"theirs", "them", "themselves", "then", "thence", "there", "theres", "thereafter", "thereby", "therefore",
			"therein", "theres", "thereupon", "these", "they", "theyd", "theyll", "theyre", "theyve", "think", "third",
			"this", "thorough", "thoroughly", "those", "though", "three", "through", "throughout", "thru", "thus", "to",
			"together", "too", "took", "toward", "towards", "tried", "tries", "truly", "try", "trying", "twice", "two",
			"un", "under", "unfortunately", "unless", "unlikely", "until", "unto", "up", "upon", "us", "use", "used",
			"useful", "uses", "using", "usually", "value", "various", "very", "via", "viz", "vs", "want", "wants",
			"was", "wasnt", "way", "we", "wed", "well", "were", "weve", "welcome", "well", "went", "were", "werent",
			"what", "whats", "whatever", "when", "whence", "whenever", "where", "wheres", "whereafter", "whereas",
			"whereby", "wherein", "whereupon", "wherever", "whether", "which", "while", "whither", "who", "whos",
			"whoever", "whole", "whom", "whose", "why", "will", "willing", "wish", "with", "within", "without", "wont",
			"wonder", "would", "would", "wouldnt", "yes", "yet", "you", "youd", "youll", "youre", "youve", "your",
			"yours", "yourself", "yourselves", "zero" };

	public static void main(String[] args) {
		// Set Strings 
		String a = "In order to integrate, you must first learn differentiation";
		String b = "Integration doesn't require that you must learn to differentiate";
		
		//Tokenize both strings and remove all stop words
		ArrayList<String> aList = null; 
		ArrayList<String> bList = null;
		try {
			aList = new ArrayList<String>(process(a));
			bList = new ArrayList<String>(process(b));
		} catch (JWNLException e) {
			e.printStackTrace();	
		}
		
		//Print Percentage Match
		System.out.println("You have a " + getPercentageSimilarity(aList, bList) + " match!");
	}
	
	public static double getPercentageSimilarity(ArrayList<String> a, ArrayList<String> b) {
		double aSize = a.size();
		ArrayList<String> clone = (ArrayList<String>)a.clone();
		clone.removeAll(b);
		return (1 - clone.size() / aSize);
	}

	public static ArrayList<String> process(String str) throws JWNLException {
		ArrayList<String> wordList = new ArrayList<String>(stop(str.toLowerCase()));
		prepareString(wordList);
		//matchSynonyms(wordList);
		System.out.println(wordList);
		stem(wordList);
		System.out.println(wordList);
		mergeSort(wordList, 0, wordList.size() - 1);
		return wordList;
	}

	public static void matchSynonyms(ArrayList<String> a, ArrayList<String> b) throws JWNLException {
		JWNL.initialize(null);
		Dictionary d = Dictionary.getInstance();
		//Word word = new Word(a.get(0));
//		for (int i = 0; i < a.size(); i++) {
//			for (int j = 0; j < b.size(); j++) {
//				
//			}
//		}
	}

	public static ArrayList<String> stop(String str) {
		HashSet<String> words = new HashSet<String>(Arrays.asList(str.split(" ")));
		for (int i = 0; i < stopWords.length; i++) {
			words.remove(stopWords[i]);
		}

		return new ArrayList<String>(words);
	}

	public static ArrayList<String> stem(ArrayList<String> tokens) {
		portersAlgorithm stem = new portersAlgorithm();
		int count = 0;
		for (String i : tokens) {
			String s1 = stem.step1(i);
			String s2 = stem.step2(s1);
			String s3 = stem.step3(s2);
			String s4 = stem.step4(s3);
			String s5 = stem.step5(s4);
			tokens.set(count, s5);
			count++;
		}
		return tokens;
	}

	public static ArrayList<String> prepareString(ArrayList<String> list) {
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			str = str.toLowerCase();
			if (str.length() > 1) {
				while (!Character.isLetter(str.charAt(str.length() - 1))
						&& !Character.isDigit(str.charAt(str.length() - 1))) {
					str = str.substring(0, str.length() - 1);
				}

				while (!Character.isLetter(str.charAt(0)) && !Character.isDigit(str.charAt(0))) {
					str = str.substring(1, str.length());
				}
			}
			list.set(i, str.toLowerCase());
		}
		return list;
	}

	private static void mergeSort(ArrayList<String> a, int first, int last) {
		if (first == last) {

		} else if (last == first + 1) {
			if (a.get(first).compareTo(a.get(last)) > 0) {
				swap(a, first, last);
			}
		} else {
			int mid = (first + last) / 2;
			mergeSort(a, first, mid);
			mergeSort(a, mid + 1, last);
			merge(a, first, mid, last);
		}

	}

	private static void swap(ArrayList<String> swap, int a, int b) {
		String hold = swap.get(a);
		swap.set(a, swap.get(b));
		swap.set(b, hold);
	}

	private static void merge(ArrayList<String> full, int first, int mid, int last) {
		ArrayList<String> a = new ArrayList<String>();
		ArrayList<String> b = new ArrayList<String>();
		// ArrayList<Comparable> temp = new ArrayList<Comparable>();
		// fill a and b
		for (int i = first; i <= last; i++) {
			if (i < mid + 1) {
				a.add(full.get(i));
			} else {
				b.add(full.get(i));
			}
		}
		// init i and j and counter
		int i = 0;
		int j = 0;
		int p = first;

		while (i < a.size() && j < b.size()) {
			if (a.get(i).compareTo(b.get(j)) < 0) {
				full.set(p++, a.get(i++));
			} else if (a.get(i).compareTo(b.get(j)) > 0) {
				full.set(p++, b.get(j++));
			} else {
				full.set(p++, a.get(i++));
			}
		}
		if (j >= b.size() && i < a.size()) {
			for (int w = i; w < a.size(); w++) {
				full.set(p++, a.get(w));
			}
		} else if (i >= a.size() && j < b.size()) {
			for (int w = j; w < b.size(); w++) {
				full.set(p++, b.get(w));
			}
		}
	}
}
