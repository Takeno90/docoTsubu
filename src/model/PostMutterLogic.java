package model;

import java.util.List;

public class PostMutterLogic {
	public void execute(Mutter mutter,List<Mutter> mutterList) {

		//Mutterインスタンスをリストに加える
		mutterList.add(0,mutter);
	}
}
