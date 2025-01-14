class Rectangle {
    Point P1,P2;
    
    Rectangle(){
	P1 = P2 = new Point(0,0);
    }

    Rectangle(int x1,int y1,int x2,int y2) {
	P1 = new Point(x1,y1);
	P2 = new Point(x2,y2);
    }
    Rectangle(Point p1, Point p2){
	P1 = p1;
	P2 = p2;	
    }
    public int area(){
	int a = (P2.x-P1.x)*(P2.y-P1.y);
	return (a);
    }
    public int perimeter(){
	int p = (P2.x-P1.x)*2+(P2.y-P1.y)*2;
	return (p);
    }
    public boolean pointInside(Point p){
        return (p.x>=P1.x && p.x<=P2.x && p.y>=P1.y && p.y<=P2.y);
    }
    public boolean rectangleInside(Rectangle r){
	return (pointInside(r.P1) && pointInside(r.P2));
    }
}
