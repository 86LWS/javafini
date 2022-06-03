package rr.ui;

import java.util.HashMap;

import javafx.scene.image.Image;

public class RRImage {
	private HashMap<String, Image> imlist=new HashMap<>();
	public RRImage() {
		imlist.put("bg-1", new Image("/rr/ui/bg-1.png"));
		imlist.put("bg-2", new Image("/rr/ui/bg-2.png"));
		imlist.put("blue-1", new Image("/rr/ui/card-blue-1.png"));
		imlist.put("blue-2", new Image("/rr/ui/card-blue-2.png"));
		imlist.put("blue-3", new Image("/rr/ui/card-blue-3.png"));
		imlist.put("blue-4", new Image("/rr/ui/card-blue-4.png"));
		imlist.put("green-1", new Image("/rr/ui/card-green-1.png"));
		imlist.put("green-2", new Image("/rr/ui/card-green-2.png"));
		imlist.put("green-3", new Image("/rr/ui/card-green-3.png"));
		imlist.put("green-4", new Image("/rr/ui/card-green-4.png"));
		imlist.put("red-1", new Image("/rr/ui/card-red-1.png"));
		imlist.put("red-2", new Image("/rr/ui/card-red-2.png"));
		imlist.put("red-3", new Image("/rr/ui/card-red-3.png"));
		imlist.put("red-4", new Image("/rr/ui/card-red-4.png"));
		imlist.put("yellow-1", new Image("/rr/ui/card-yellow-1.png"));
		imlist.put("yellow-2", new Image("/rr/ui/card-yellow-2.png"));
		imlist.put("yellow-3", new Image("/rr/ui/card-yellow-3.png"));
		imlist.put("yellow-4", new Image("/rr/ui/card-yellow-4.png"));
		imlist.put("mirror-blue-1", new Image("/rr/ui/mirror-blue-1.png"));
		imlist.put("mirror-blue-2", new Image("/rr/ui/mirror-blue-2.png"));
		imlist.put("mirror-red-1", new Image("/rr/ui/mirror-red-1.png"));
		imlist.put("mirror-red-2", new Image("/rr/ui/mirror-red-2.png"));
		imlist.put("mirror-white-1", new Image("/rr/ui/mirror-white-1.png"));
		imlist.put("mirror-white-2", new Image("/rr/ui/mirror-white-2.png"));
		imlist.put("mirror-yellow-1", new Image("/rr/ui/mirror-yellow-1.png"));
		imlist.put("mirror-yellow-2", new Image("/rr/ui/mirror-yellow-2.png"));
		imlist.put("mirror-green-1", new Image("/rr/ui/mirror-green-1.png"));
		imlist.put("mirror-green-2", new Image("/rr/ui/mirror-green-2.png"));
		imlist.put("player-green", new Image("/rr/ui/player-green.png"));
		imlist.put("player-white", new Image("/rr/ui/player-white.png"));
		imlist.put("player-yellow", new Image("/rr/ui/player-yellow.png"));
		imlist.put("player-blue", new Image("/rr/ui/player-blue.png"));
		imlist.put("player-red", new Image("/rr/ui/player-red.png"));
		imlist.put("spawn-green", new Image("/rr/ui/player-spawn-green.png"));
		imlist.put("spawn-yellow", new Image("/rr/ui/player-spawn-yellow.png"));
		imlist.put("spawn-white", new Image("/rr/ui/player-spawn-white.png"));
		imlist.put("spawn-blue", new Image("/rr/ui/player-spawn-blue.png"));
		imlist.put("spawn-red", new Image("/rr/ui/player-spawn-red.png"));
		imlist.put("wall1", new Image("/rr/ui/wall1.png"));
		imlist.put("wall2", new Image("/rr/ui/wall2.png"));
		imlist.put("wall3", new Image("/rr/ui/wall3.png"));
		imlist.put("wall4", new Image("/rr/ui/wall4.png"));
		imlist.put("no-entry-zone", new Image("/rr/ui/no-entry-zone.png"));
	}
	public Image getImageOfId(String id) {
		return imlist.get(id);
	}
}
