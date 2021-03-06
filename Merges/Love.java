import java.util.*;

// Rectangles on a 2-D grid represent the personalities of people looking for love. The more a person's rectangle overlaps with another
// person's rectangle, the greater the probability that they will fall in love with one another. The sides of the rectangles will either
// be parallel with the x-axis or the y-axis. Write a function that returns the rectangular intersection (love rectangle) of any
// two rectangles belonging to lonely romantics.



public class Love {

	// This is how we will describe a rectangle on the 2-D grid.
	public class LoveRectangle {

		// Coordinates of the lower left corner.
		int x;
		int y;
		// Width and height of the rectangle.
		int width;
		int height;

	}

	public LoveRectangle strengthOfLove(LoveRectangle loverOne , LoveRectangle loverTwo) {

		LoveRectangle love_strength = new LoveRectangle();
		love_strength.width = 0;
		love_strength.height = 0;
		love_strength.x = -1;
		love_strength.y = -1;

		Map.Entry<Integer, Integer> xAxisIntersection  = findOverlapThisDim(new AbstractMap.SimpleEntry<>(loverOne.x, loverOne.width)  , new AbstractMap.SimpleEntry<>(loverTwo.x, loverTwo.width));

		if (xAxisIntersection.getValue() == 0) return love_strength;

		Map.Entry<Integer, Integer> yAxisIntersection  = findOverlapThisDim(new AbstractMap.SimpleEntry<>(loverOne.y, loverOne.height)  , new AbstractMap.SimpleEntry<>(loverTwo.y, loverTwo.height));

		if (yAxisIntersection.getValue() == 0) return love_strength;


		love_strength.width = xAxisIntersection.getValue();
		love_strength.height = yAxisIntersection.getValue();
		love_strength.x = xAxisIntersection.getKey();
		love_strength.y = yAxisIntersection.getKey();

		return love_strength;

	}

	private Map.Entry<Integer, Integer> findOverlapThisDim(Map.Entry<Integer, Integer> lover_one , Map.Entry<Integer, Integer> lover_two) {

		Map.Entry<Integer, Integer> longer_line;
		List<Integer> shorter_line;

		if (lover_one.getValue() > lover_two.getValue()) {

			longer_line = new AbstractMap.SimpleEntry<>(lover_one.getKey() , lover_one.getKey() + lover_one.getValue());
			shorter_line = Arrays.asList(lover_two.getKey() , lover_two.getKey() + lover_two.getValue());

		}
		else {

			longer_line = new AbstractMap.SimpleEntry<>(lover_two.getKey() , lover_two.getKey() + lover_two.getValue());
			shorter_line = Arrays.asList(lover_one.getKey() , lover_one.getKey() + lover_one.getValue());

		}

		Map.Entry<Integer, Integer> overlap;


		List<Integer> intersections = new ArrayList<>(2);

		for (int x : shorter_line) {

			if (x >= longer_line.getKey() && x <= longer_line.getValue()) intersections.add(x);

		}


		if (intersections.size() == 2) {

			return new AbstractMap.SimpleEntry<>(shorter_line.get(0) , shorter_line.get(1) - shorter_line.get(0)) ;

		}
		else if (intersections.size() == 0) {

			return new AbstractMap.SimpleEntry<>(-1 , 0);

		}


		if (intersections.get(0) == shorter_line.get(0)) {

			overlap = new AbstractMap.SimpleEntry<>(shorter_line.get(0) , longer_line.getValue() - shorter_line.get(0));

		}
		else {

			overlap = new AbstractMap.SimpleEntry<>(longer_line.getKey() , shorter_line.get(1) - longer_line.getKey());

		}

		return overlap;

	}



}
