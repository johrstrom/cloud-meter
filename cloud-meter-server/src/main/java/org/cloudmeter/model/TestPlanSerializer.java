package org.cloudmeter.model;

import java.io.IOException;
import java.util.Stack;

import org.apache.jorphan.collections.HashTree;
import org.apache.jorphan.collections.HashTreeTraverser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class TestPlanSerializer extends JsonSerializer<HashTree>  {
	
	private static final Logger log = LoggerFactory.getLogger(TestPlanSerializer.class);

	@Override
	public void serialize(HashTree arg0, JsonGenerator arg1, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		
		log.debug("serializing a hash tree.");
		
		arg0.traverse(new JSonTraverser(arg1));
		
		
	}
	
	class JSonTraverser implements HashTreeTraverser {

		private JsonGenerator jsonGen;
		private Stack<Object> stack = new Stack<>();
		
		JSonTraverser(JsonGenerator arg1){
			this.jsonGen = arg1;
		}
		
		@Override
		public void addNode(Object node, HashTree subTree) {
			
			stack.add(node);
							
			try {
				jsonGen.writeObject(node);
				
			} catch (IOException e) {
				
				log.error("Cannot add node. ", e);
			}
				

		}

		@Override
		public void subtractNode() {
			this.stack.pop();
		}

		@Override
		public void processPath() {
			

			
		}
		
	}


}
