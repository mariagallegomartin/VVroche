import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DijkstraTest {
	
	static Dijkstra dijkstra,dijkstra3;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		/*Path 1 y 2*/
				Double [][] mpath = new Double[3][3];
				for(int i=0; i<3;i++) {
					for(int j=0; j<3;j++)
						mpath[i][j]= Double.POSITIVE_INFINITY;
				}
				mpath[0][1]=2.0;mpath[1][2]=1.0;mpath[0][2]=5.0;
				Integer numV = new Integer(3);
				dijkstra = new Dijkstra(mpath,numV);
				dijkstra.computeShortestPath(0, 2);
		//Path 3
				Double [][] mpath3 = new Double[1][1];
				mpath3[0][0]= Double.POSITIVE_INFINITY;
				Integer numV3 = new Integer(1);
				dijkstra3 = new Dijkstra(mpath3,numV3);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetPath1() {
		/*PATH1:
		 *Es un grafo ya ejecutado por lo que en el primero rombo va a la izquierda
		 *pero que no entra en el bucle while*/
		dijkstra.getPath(0, 0);
		assertEquals("155 160 164 165 166 171 ", dijkstra.line);
	}
	
	@Test
	void testGetPath2() {
		/*PATH2:
		 *Es un grafo ya ejecutado por lo que en el primero rombo va a la izquierda
		 *pero que entra en el bucle while*/
		dijkstra.getPath(0, 2);
		assertEquals("155 160 164 165 166 167 168 167 168 171 ", dijkstra.line);
	}
	
	@Test
	void testGetPath3() {
		/*PATH3:
		 *Es un grafo no ejecutado por lo que en el primer rombo va a la derecha
		 *y ahí finaliza*/
		dijkstra3.getPath(new Integer(0), new Integer(0));
		assertEquals("155 156 157 ", dijkstra3.line);
	}

}
