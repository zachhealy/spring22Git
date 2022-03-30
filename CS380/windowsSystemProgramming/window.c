// Compile With gcc window.c -o window.exe -lgdi32
#define UNICODE
#define _UNICODE
#include <windows.h>
#include <tchar.h>
#include <stdio.h>

const TCHAR CLSNAME[] = TEXT("helloworldWClass");
LRESULT CALLBACK winproc(HWND hwnd, UINT wm, WPARAM wp, LPARAM lp);

HWND btnOne;
HWND btnTwo;
HWND btnThree;
HWND btnFour;

int APIENTRY WinMain(HINSTANCE hInst, HINSTANCE hPrevInst, PSTR cmdline, int cmdshow)
{
    WNDCLASSEX wc;
    MSG msg;
    HWND hwnd;

    wc.cbSize        = sizeof (wc);
    wc.style         = 0;
    wc.lpfnWndProc   = winproc;
    wc.cbClsExtra    = 0;
    wc.cbWndExtra    = 0;
    wc.hInstance     = hInst;
    wc.hIcon         = LoadIcon (NULL, IDI_APPLICATION);
    wc.hCursor       = LoadCursor (NULL, IDC_ARROW);
    wc.hbrBackground = (HBRUSH) GetStockObject (WHITE_BRUSH);
    wc.lpszMenuName  = NULL;
    wc.lpszClassName = CLSNAME;
    wc.hIconSm       = LoadIcon (NULL, IDI_APPLICATION);

    if (!RegisterClassEx(&wc)) {
        MessageBox(NULL, TEXT("Could not register window class"), 
                  NULL, MB_ICONERROR);
        return 0;
    }

    hwnd = CreateWindowEx(WS_EX_LEFT,
                          CLSNAME,
                          NULL,
                          WS_OVERLAPPEDWINDOW,
                          CW_USEDEFAULT,
                          CW_USEDEFAULT,
                          CW_USEDEFAULT,
                          CW_USEDEFAULT,
                          NULL,
                          NULL,
                          hInst,
                          NULL);
    if (!hwnd) {
        MessageBox(NULL, TEXT("Could not create window"), NULL, MB_ICONERROR);
        return 0;
    }
    //Add buttons here
    btnOne = CreateWindow( L"BUTTON", L"One", WS_VISIBLE | WS_CHILD | BS_DEFPUSHBUTTON,
        400, 400, 100, 100, hwnd, (HMENU) 0, hInst, NULL);

    btnTwo = CreateWindow( L"BUTTON", L"Two", WS_VISIBLE | WS_CHILD | BS_DEFPUSHBUTTON,
        500, 400, 100, 100, hwnd, (HMENU) 1, hInst, NULL);

    btnThree = CreateWindow( L"BUTTON", L"Quit", WS_VISIBLE | WS_CHILD | BS_DEFPUSHBUTTON,
        400, 500, 100, 100, hwnd, (HMENU) 2, hInst, NULL);

    btnFour = CreateWindow( L"BUTTON", L"Don't. Click.", WS_VISIBLE | WS_CHILD | BS_DEFPUSHBUTTON,
        500, 500, 100, 100, hwnd, (HMENU) 3, hInst, NULL);

    //Back to Default Code
    ShowWindow(hwnd, cmdshow);
    UpdateWindow(hwnd);
    while (GetMessage(&msg, NULL, 0, 0)) {
        TranslateMessage(&msg);
        DispatchMessage(&msg);
    }
    return msg.wParam;
}

LRESULT CALLBACK winproc(HWND hwnd, UINT wm, WPARAM wp, LPARAM lp)
{
    //Switch case for what buttons do
    switch (wm) {
    case WM_DESTROY:
        PostQuitMessage(0);
        break;
    case WM_COMMAND:
        switch (LOWORD(wp)) {
            case 0: {
                SetWindowTextA(hwnd, "One Fish");
                HDC dc = GetDC(hwnd);
                SetTextColor(dc, 0x0099FFCC);
                SetBkColor(dc, 0x00663311);
                TextOutA(dc, 490, 300, "ONE", 3);
                ReleaseDC(btnOne, dc);
                break;
            
            }
            case 1: {
                SetWindowTextA(hwnd, "Two Fish");
                HDC dc = GetDC(hwnd);
                SetTextColor(dc, 0x000000FF);
                SetBkColor(dc, 0x00663366);
                TextOutA(dc, 490, 300, "TWO", 3);
                ReleaseDC(btnTwo, dc);
                break;

            }
            case 2: {
                PostQuitMessage(0);
                break;
            
            }
            case 3: {
                SetWindowTextA(hwnd, "I tried to warn you");
                HDC dc = GetDC(hwnd);
                SetTextColor(dc, 0x00FF66FF);
                SetBkColor(dc, 0x00FF3300);
                TextOutA(dc, 490, 300, "Try to stop the program", 24);

                //I am trying to use the ClipCursor Function in order to contain
                //the cursor to the area of the "Quit" button, trapping the user.
                //But I can't seem to get it working, not sure if I am using the 
                //function wrong, but thought you'd enjoy the idea behind it
                ClipCursor(Rectangle(dc, 400, 500, 500, 600));

                ReleaseDC(btnFour, dc);
                break;
            }
        }
    }

    return DefWindowProc(hwnd, wm, wp, lp);

}