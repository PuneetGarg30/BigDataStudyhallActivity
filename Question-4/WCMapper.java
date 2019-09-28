package mapreduceproblem;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class WCMapper extends MapReduceBase implements Mapper<LongWritable,Text,Text,IntWritable>
{
	private final static IntWritable one=new IntWritable(1);
	private Text word=new Text();
	public void map(LongWritable key, Text value, OutputCollector<Text,IntWritable> output, Reporter reporter) throws IOException
	{
		String line=value.toString();
		String[] tokenizer= line.split(",");
		
		for(int x=0; x<tokenizer.length; x++){
			if(x == 1){
				if(tokenizer[x].equals("Product1") || tokenizer[x].equals("Product2")){
				word.set(tokenizer[x]);
				output.collect(word,one);}
			}
		}
	}

}
