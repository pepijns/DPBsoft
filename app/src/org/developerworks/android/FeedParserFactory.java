package org.developerworks.android;
public abstract class FeedParserFactory {
	static String feedUrl = "http://www.nu.nl/feeds/rss/games.rss";
	
	public static FeedParser getParser(){
		return getParser(ParserType.ANDROID_SAX,"");
	}
	
	public static FeedParser getParser(ParserType type, String url){
		switch (type){
			case SAX:
				return new SaxFeedParser(url);
			case DOM:
				return new DomFeedParser(url);
			case ANDROID_SAX:
				return new AndroidSaxFeedParser(url);
			case XML_PULL:
				return new XmlPullFeedParser(url);
			default: return null;
		}
	}
}
