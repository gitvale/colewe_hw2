package uni.colewe.server;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import uni.colewe.shared.MyDictionaryEntry;

public class MyDictionary {
	private static Logger logger = Logger.getLogger(MyDictionary.class.getName());
	   
	private static final String DATA = "Паликир	N	1) Palikir (capital of Micronesia)#Пангея	N	1) Pangaea ''(hypothetical primordial supercontinent of the Mesozoic era)''#Пасха	N	1) Easter 2) Passover#Пепельная среда	N	1) Ash Wednesday#Петроград	N	1) Petrograd [historical]#Петропавловка	N	1) Peter and Paul Fortress [colloquial]#Пикассо прямоугольчатый	N	1) humuhumunukunukuapuaa#Политбюро	N	1) Politburo of the Communist Party of the Soviet Union [historical]#Посейдон	N	1) Poseidon [Greek god]#Принц Альберт	N	1) Prince Albert (piercing)#РЖД	N	1) Russian Railways ''or'' '''Rossiyskie Zheleznye Dorogi''' (RZhD)#РИК	N	1) RIC (Russia, India, China)#РКК	N	1) Workers’ and Peasants’ Inspectorate#РКК	N	1) RCC, Radio Communications Company#РКК	N	1) Rocket and Space Complex#РКК	N	1) Raketno-kosmičeskaja korporacija (Rocket and Space Corporation)#РКК	N	1) RRC, Russian Red Cross#РНК	N	1) RNA#РНР	N	1) work permit#РОНО	N	1) district department of people's education#РОСТО	N	1) Russian Defence Sports-Technical Organization#РПЦ	N	1) Russian Orthodox Church#РСФСР	N	1) RSFSR (Russian Soviet Federative Socialist Republic, 1917 to 1991)#РФ	N	1) Russian Federation (RF, an informal abbreviation for the name of the modern (since 1991) country, yet widely used in official documents)#Раиса	N	1) female given name, Raisa.#Ричмонд	N	1) the capital city of Virginia 2) a common place name in English-speaking countries#Рождество	N	1) Christmas (''lit.'', the Birth) 2) nativity#Роно	N	1) [spelling variant of РОНО́]#Рунет	N	1) The Russian-language websites on the Internet, taken as a whole#Рюрик	N	1) male given name, Ryurik, Rurik.#С	N	1)  [chess]#СИЗО	N	1) remand prison, jail (for suspects), detention facility#СКФО	N	1) North Caucasian Federal District#СМЕРШ	N	1) SMERSH#СМИ	N	1) mass media#СМС	N	1) Short Message Service 2) SMS, message, text#СНВ	N	1) strategic (offensive) arms#сбалансированность	N	1) balance, harmony#сбербанк	N	1) savings bank#сберегательная книжка	N	1) passbook, bankbook#сбережение	N	1) (usually plural) savings 2) economy, saving#сберкасса	N	1) savings bank#сберкнижка	N	1) passbook#сближение	N	1) convergence#сбой	N	1) failure, fault, error 2) losing the step, falling out of step [sport]#сбор	N	1) collection, accumulation, gathering, harvest, picking 2) levy, tax, duty, receipts 3) muster, assembly [military] 4) assembly, meeting, get-together#сборище	N	1) assemblage, gathering of people 2) mob#сборка	N	1) assembly, assemblage#сборная	N	1) combined team, national sports team#сборник	N	1) collection [book] 2) storage tank, receptacle [engineering]#сборщик	N	1) collector#сброд	N	1) scum, mob, riffraff, rabble, varletry, ragtag and bobtail [pejorative]#сброс	N	1) water escape 2) dumping, discharge 3) reduction, dropping 4) reset, resetting, clearance, nulling, nullification, zeroing [informatics] 5) fault [geology]#сбруя	N	1) harness#сбыт	N	1) sale#свадьба	N	1) wedding#свалка	N	1) dump, junkyard 2) dumping 3) scuffle, brawl [colloquial]#свара	N	1) quarrel, squabble [colloquial]#сварка	N	1) welding, weld#сварщик	N	1) welder#свастика	N	1) swastika, fylfot#сват	N	1) matchmaker, go-between 2) father of one’s son-in-law or of one’s daughter-in-law. [colloquial]#сватовство	N	1) matchmaking 2) courtship#свая	N	1) pile#сведение	N	1) information, intelligence 2) notice, knowledge#сведение	N	1) reduction 2) squaring (of accounts) 3) contraction, cramp [medicine]#свежесть	N	1) freshness#свекла	N	1) [variant of свёкла]#свекольник	N	1) a cold borsht, usually without meat, usually eaten in the summer#свекровь	N	1) a woman’s mother-in-law ''(husband’s mother only)''#свердловчанин	N	1) citizen of Sverdlovsk [historical]#свержение	N	1) dethronement#сверка	N	1) verification, collation 2) revision [printing]#сверкание	N	1) glitter, sparkle, scintillation, glisten, glister 2) flash, flashing 3) glint 4) flare 5) glance 6) twinkle 7) coruscation 8) lambency#сверлило	N	1) timber beetle, lymexylonid (Lymexylon navale)#сверло	N	1) drill, drill bit, auger, bore#сверстник	N	1) contemporary 2) coeval 3) age-mate#сверстница	N	1) female contemporary, age-mate#сверхдержава	N	1) superpower#сверхзадача	N	1) super-task#сверхновая звезда	N	1) supernova#сверхприбыль	N	1) superprofit, excess profit [finance]#сверхтекучесть	N	1) superfluidity#сверхурочные	N	1) overtime#сверхчеловек	N	1) superman, overman [philosophy] 2) strong personality whose actions and desires do not obey normal restrictions 3) great man [colloquial] 4) übermensch, Aryan [journalistic, Nazism]#сверчок	N	1) cricket 2) grass warbler ''(Locustella)''";
	
	private static  String dataPath = "C://_projects//GWT//SecondHomework//war//WEB-INF//dictdata.txt";
	
	private Map<String, MyDictionaryEntry> ruToEng = new HashMap<String, MyDictionaryEntry>();
	private Map<String, List<String>> engToRu = new HashMap<String, List<String>>();
	
	private MyPrefixTree rusTree = new MyPrefixTree();
	private MyPrefixTree engTree = new MyPrefixTree();

	public MyDictionary(String datapath) {
		this.dataPath = datapath;
		init();
	}

	private List<String> init() {
		List<String> errs = new ArrayList<String>();
		try {
			readData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		List<String> lines = Arrays.asList(DATA.split("#"));
//		for (String line : lines) {
//			String err = processLine(line);
//			if (!err.isEmpty()) {
//				errs.add(err);
//			}
//		}
		return errs;
	}
	
	private void readData() throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(dataPath), StandardCharsets.UTF_8));
		while(true){
			String line = reader.readLine();
			if(line != null && !line.trim().isEmpty()){
				processLine(line);
			} else {
				break;
			}
		}
		reader.close();
	}

	private String processLine(String line) {

		// split by tabs
		String[] split = line.split("\t");
		if (split.length != 3) {
			return "Invalid split:  " + line;
		}
		String rus = split[0].trim();
		String pos = split[1].trim();
		String eng = split[2].trim();
		
		MyDictionaryEntry entry = new MyDictionaryEntry(rus, pos, eng);

		// add russian lemma
		rusTree.addEntry(rus, entry);
		if (ruToEng.get(rus) == null) {
			ruToEng.put(rus, entry);
		} else {
			return "Duplicate lemma: " + rus;
		}

		// process english part -strip special chars, tokenize
		for (String token : tokenizeEng(eng)) {
			engTree.addEntry(token, entry);
			if (engToRu.get(token) == null) {
				engToRu.put(token, new ArrayList<String>());
			}
			((ArrayList<String>) engToRu.get(token)).add(rus);
		}
		return "";
	}

	private List<String> tokenizeEng(String eng) {
		String clean = eng.replaceAll("((?<!\\d)\\d{1}\\))|[\\(\\)\\[\\]\\'\\.,]", "").trim();
		return Arrays.asList(clean.split("\\s+"));
	}

	public Set<MyDictionaryEntry> treeLookUp(String query, boolean reverse, boolean startsWith){
		if(query.trim().isEmpty()){
			return new HashSet<MyDictionaryEntry>();
		}
		if(reverse){
			return engTree.getEntries(query, startsWith);
		} else {
			return rusTree.getEntries(query, startsWith);
		}
	}

	public Set<MyDictionaryEntry> mapLookUp(String query, boolean reverse, boolean startswith) {
		Set<MyDictionaryEntry> results = new HashSet<MyDictionaryEntry>();
		if(query.trim().isEmpty()){
			return results;
		}
		if (reverse) {
			if (startswith) {
				for(String key : engToRu.keySet()){
					if(key.startsWith(query)){
						results.add(ruToEng.get(engToRu.get(key)));
					}
				}
			} else {
				if(engToRu.get(query) != null){
					results.add(ruToEng.get(engToRu.get(query)));
				}
			}
		} else {
			if (startswith) {
				for(String key : ruToEng.keySet()){
					if(key.startsWith(query)){
						results.add(ruToEng.get(key));
					}
				}
			} else {
				if(ruToEng.get(query) != null){
					results.add(ruToEng.get(query));
				}
			}
		}
		return results;
	}

//	private String getHTMLString(Set<String> results, String query, boolean reverse, boolean startswith, boolean highlight) {
//		if(results.isEmpty()){
//			return "<p>No results found for query: " + query + "</p>";
//		} else {
//			StringBuilder sb = new StringBuilder();
//			sb.append("<table style=\"width:100%\">\n"
//					+ "<tr>\n"
//					+ "<th align=\"left\">Russian</th>\n"
//					+ "<th align=\"left\">POS</th>\n"
//					+ "<th align=\"left\">English</th>\n"
//					+ "</tr>\n");
//			
//			for (String result : results) {
//				String pos = ruToEng.get(result).getPos();
//				String eng = ruToEng.get(result).getEng();
//				if (highlight) {
//					if (reverse) {
//						eng = highlightString(eng, query, startswith);
//					} else {
//						result = highlightString(result, query, startswith);
//					}
//				}
//				sb.append("<tr>\n"
//						+ "<td>"+ result +"</td>\n"
//						+ "<td>"+ pos +"</td>\n"
//						+ "<td>"+ eng +"</td>\n"
//						+ "</tr>\n");
//				
//			}
//			sb.append("</table>");
//			return sb.toString();
//		}	
//	}
	
	private String highlightString(String target, String query, boolean startswith) {
		// note that regex needs to conform to js conventions
		if(startswith){
//			logger.log(Level.INFO, target.replaceAll("(^|[\\s\\(\\)\\[\\]\\.,])(" + query + ")", "$1<mark>$2</mark>"));
			return target.replaceAll("(^|[\\s\\(\\)\\[\\]\\.,])(" + query + ")", "$1<mark>$2</mark>");
//			return target.replaceAll("(?<=^|\\s+|[\\(\\)\\[\\]\\.,])(\\Q" + query + "\\E)", "<mark>$1</mark>");		
		} else {
//			logger.log(Level.INFO, target.replaceAll("(^|[\\s\\(\\)\\[\\]\\.,])(" + query + ")([\\s\\(\\)\\[\\]\\.,]|$)", "$1<mark>$2</mark>$3"));
			return target.replaceAll("(^|[\\s\\(\\)\\[\\]\\.,])(" + query + ")([\\s\\(\\)\\[\\]\\.,]|$)", "$1<mark>$2</mark>$3");
//			return target.replaceAll("(?<=^|\\s+|[\\(\\)\\[\\]\\.,])(\\Q" + query + "\\E)(?=\\s+|$|[\\(\\)\\[\\]\\.,])", "<mark>$1</mark>");
		}
	}


}
