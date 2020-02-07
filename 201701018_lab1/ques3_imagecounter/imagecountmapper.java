import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class imagecountmapper
  extends Mapper<LongWritable, Text, Text, IntWritable> {
  
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    
    String line = value.toString();
    //int i=0,s=0;
    //while(s!=7)	if(line.charAt(i++)==' ')	s++;
    //String ext = line.substring(i-4,i-1);
    String format="";
    if(line.contains("jpg"))	format="jpg";
    else if(line.contains("gif"))	format="gif";
    else	format="others";
    if(line.contains("GET") && line.contains("images"))
    	context.write(new Text(format), new IntWritable(1));

  }
}

