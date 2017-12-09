#define UP 72
#define DOWN 80
#define LEFT 75
#define RIGHT 77
#define MAX_X 60
#define MAX_Y 20

// Prototypes
void welcome();
void end();
void wait();
void gotoxy(unsigned short, unsigned short);
void Creation();
void add_body(int, int);
void Draw();
void display();
void input();
void direction();
void move(int, int);
void food();
void check();
void self_eat();
void deallocation();
int main();